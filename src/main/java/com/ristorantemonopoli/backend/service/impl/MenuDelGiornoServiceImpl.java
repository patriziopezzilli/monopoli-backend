package com.ristorantemonopoli.backend.service.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.ristorantemonopoli.backend.database.entity.MenuDelGiorno;
import com.ristorantemonopoli.backend.database.entity.MenuDelGiornoData;
import com.ristorantemonopoli.backend.database.repository.MenuDelGiornoDataRepository;
import com.ristorantemonopoli.backend.database.repository.MenuDelGiornoRepository;
import com.ristorantemonopoli.backend.dto.MenuDelGiornoSaveRequest;
import com.ristorantemonopoli.backend.dto.PastoDTO;
import com.ristorantemonopoli.backend.dto.SubscriberDTO;
import com.ristorantemonopoli.backend.service.MailService;
import com.ristorantemonopoli.backend.service.MenuDelGiornoService;
import com.ristorantemonopoli.backend.service.SubscriberService;
import com.ristorantemonopoli.backend.utils.TemplateUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.ristorantemonopoli.backend.constants.InternalTemplateUtils.*;
import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class MenuDelGiornoServiceImpl implements MenuDelGiornoService {

    @Autowired
    private MenuDelGiornoRepository repository;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private MailService mailService;

    @Autowired
    private MenuDelGiornoDataRepository menuDelGiornoDataRepository;

    @Value("classpath:menudelgiorno.txt")
    private Resource resource;

    private String getMenuDelGirornoInternal() {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static void convertAndUpload(String html)
            throws DocumentException, FileNotFoundException, IOException, Exception {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, out);
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new ByteArrayInputStream(html.getBytes()));
        document.close();


        String server = "lhcp3004.webapps.net";
        int port = 21;
        String user = "n63o4crk";
        String pass = "86h4n*8g%(*u";

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            String firstRemoteFile = "/public_html/menudelgiorno/generato/menudelgiorno.pdf";
            InputStream inputStream = new ByteArrayInputStream(out.toByteArray());

            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("The first file is uploaded successfully.");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<PastoDTO> retrievePasti(String categoria) {

        /**
         * retrieve
         */
        List<MenuDelGiorno> menuDelGiornos = repository.findByCategoria(categoria);

        List<PastoDTO> pastoDTOS = new ArrayList<>();

        if (menuDelGiornos != null) {
            menuDelGiornos.forEach(c -> pastoDTOS.add(
                    new PastoDTO(
                            c.getNome(),
                            null,
                            c.getPrezzo() + "€",
                            c.getCategoria()
                    )
            ));
        }

        /**
         * remove duplicates
         */
        ArrayList<PastoDTO> newList = new ArrayList<>();
        for (PastoDTO element : pastoDTOS) {
            boolean alreadyPresent = false;

            for (PastoDTO pastoDTO : newList) {
                if (pastoDTO.getNome().equals(element.getNome()) && pastoDTO.getCategoria().equals(element.getCategoria())) {
                    alreadyPresent = true;
                }
            }

            if (!alreadyPresent) {
                newList.add(element);
            }
        }

        return newList;
    }

    @Override
    public void saveMenuDelGiorno(MenuDelGiornoSaveRequest request) {
        if (null != request) {
            repository.deleteAll();

            if (null != request.getPrimi()) {
                request.getPrimi().forEach(p -> {
                    String capitalizedName = (StringUtils.capitalize(p.getNome()));
                    p.setNome(capitalizedName);

                    if (p.getPrezzo().contains(",")) {
                        p.setPrezzo(p.getPrezzo().replace(",", "."));
                        p.setPrezzo(p.getPrezzo().replace("€", ""));
                    } else if (p.getPrezzo().contains(".")) {
                        // nothing
                    } else {
                        p.setPrezzo(p.getPrezzo() + ".00");
                    }
                    repository.save(new MenuDelGiorno(p.getNome(), p.getPrezzo(), p.getCategoria()));
                });
            }

            if (null != request.getSecondi()) {
                request.getSecondi().forEach(p -> {
                    String capitalizedName = (StringUtils.capitalize(p.getNome()));
                    p.setNome(capitalizedName);

                    if (p.getPrezzo().contains(",")) {
                        p.setPrezzo(p.getPrezzo().replace(",", "."));
                        p.setPrezzo(p.getPrezzo().replace("€", ""));
                    } else if (p.getPrezzo().contains(".")) {
                        // nothing
                    } else {
                        p.setPrezzo(p.getPrezzo() + ".00");
                    }
                    repository.save(new MenuDelGiorno(p.getNome(), p.getPrezzo(), p.getCategoria()));
                });
            }

            if (null != request.getPizze()) {
                request.getPizze().forEach(p -> {
                    String capitalizedName = (StringUtils.capitalize(p.getNome()));
                    p.setNome(capitalizedName);

                    if (p.getPrezzo().contains(",")) {
                        p.setPrezzo(p.getPrezzo().replace(",", "."));
                        p.setPrezzo(p.getPrezzo().replace("€", ""));
                    } else if (p.getPrezzo().contains(".")) {
                        // nothing
                    } else {
                        p.setPrezzo(p.getPrezzo() + ".00");
                    }
                    repository.save(new MenuDelGiorno(p.getNome(), p.getPrezzo(), p.getCategoria()));
                });
            }
        }
    }

    @Override
    public void inviaInStampa() {
        String mail = getMenuDelGirornoInternal();

        List<PastoDTO> primi = retrievePasti("primo");
        List<PastoDTO> secondi = retrievePasti("secondo");
        List<PastoDTO> pizze = retrievePasti("pizza");

        /**
         * Primi
         */
        if (null != primi && primi.size() > 0) {

            /**
             * Nomi
             */
            String listNomi = "";
            for (String s : primi.stream()
                    .map(PastoDTO::getNome)
                    .collect(Collectors.toList())) {

                listNomi += NOME_PLACEHOLDER.replace("#NOME#", s);
            }

            /**
             * Prezzo
             */
            String listPrezzi = "";
            for (String s : primi.stream()
                    .map(PastoDTO::getPrezzo)
                    .collect(Collectors.toList())) {

                listPrezzi += PREZZO_PLACEHOLDER.replace("#PREZZO#", s.replace("€", "&euro;"));
            }

            mail = mail.replace(LIST_PRIMI_NOMI, listNomi);
            mail = mail.replace(LIST_PRIMI_PREZZI, listPrezzi);
        }

        /**
         * Secondi
         */
        if (null != secondi && secondi.size() > 0) {

            /**
             * Nomi
             */
            String listNomi = "";
            for (String s : secondi.stream()
                    .map(PastoDTO::getNome)
                    .collect(Collectors.toList())) {

                listNomi += NOME_PLACEHOLDER.replace("#NOME#", s);
            }

            /**
             * Prezzo
             */
            String listPrezzi = "";
            for (String s : secondi.stream()
                    .map(PastoDTO::getPrezzo)
                    .collect(Collectors.toList())) {

                listPrezzi += PREZZO_PLACEHOLDER.replace("#PREZZO#", s.replace("€", "&euro;"));
            }

            mail = mail.replace(LIST_SECONDI_NOMI, listNomi);
            mail = mail.replace(LIST_SECONDI_PREZZI, listPrezzi);
        }

        /**
         * Pizze
         */
        if (null != pizze && pizze.size() > 0) {

            /**
             * Nomi
             */
            String listNomi = "";
            for (String s : pizze.stream()
                    .map(PastoDTO::getNome)
                    .collect(Collectors.toList())) {

                listNomi += NOME_PLACEHOLDER.replace("#NOME#", s);
            }

            /**
             * Prezzo
             */
            String listPrezzi = "";
            for (String s : pizze.stream()
                    .map(PastoDTO::getPrezzo)
                    .collect(Collectors.toList())) {

                listPrezzi += PREZZO_PLACEHOLDER.replace("#PREZZO#", s.replace("€", "&euro;"));
            }

            mail = mail.replace(LIST_PIZZE_NOMI, listNomi);
            mail = mail.replace(LIST_PIZZE_PREZZI, listPrezzi);
        }

        try {
            String subject = "Menu del giorno da stampare";
            mailService.sendMail(Arrays.asList("patriziopezzilli@gmail.com"), subject, mail);
            convertAndUpload(mail);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void notificaClienti() {
        String mail = (TemplateUtils.BASE_TEMPLATE_CLIENTI);

        List<PastoDTO> primi = retrievePasti("primo");
        List<PastoDTO> secondi = retrievePasti("secondo");
        List<PastoDTO> pizze = retrievePasti("pizza");

        /**
         * Replace date
         */
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatter.format(date);
        mail = mail.replace("#DATA", dataStr);

        /**
         * Replace primi
         */
        if (1 <= primi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", primi.get(0).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(0).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO1#", contenuto);
        } else {
            mail = mail.replace("#PRIMO1#", "");
        }
        if (2 <= primi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", primi.get(1).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(1).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO2#", contenuto);
        } else {
            mail = mail.replace("#PRIMO2#", "");
        }
        if (3 <= primi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", primi.get(2).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(2).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO3#", contenuto);
        } else {
            mail = mail.replace("#PRIMO3#", "");
        }
        if (4 <= primi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", primi.get(3).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(3).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO4#", contenuto);
        } else {
            mail = mail.replace("#PRIMO4#", "");
        }
        if (5 <= primi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", primi.get(4).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(4).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO5#", contenuto);
        } else {
            mail = mail.replace("#PRIMO5#", "");
        }

        /**
         * Replace secondi
         */
        if (1 <= secondi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", secondi.get(0).getNome());
            contenuto = contenuto.replace("#PREZZO#", secondi.get(0).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#SECONDO1#", contenuto);
        } else {
            mail = mail.replace("#SECONDO1#", "");
        }
        if (2 <= secondi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", secondi.get(1).getNome());
            contenuto = contenuto.replace("#PREZZO#", secondi.get(1).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#SECONDO2#", contenuto);
        } else {
            mail = mail.replace("#SECONDO2#", "");
        }
        if (3 <= secondi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", secondi.get(2).getNome());
            contenuto = contenuto.replace("#PREZZO#", secondi.get(2).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#SECONDO3#", contenuto);
        } else {
            mail = mail.replace("#SECONDO3#", "");
        }
        if (4 <= secondi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", secondi.get(3).getNome());
            contenuto = contenuto.replace("#PREZZO#", secondi.get(3).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#SECONDO4#", contenuto);
        } else {
            mail = mail.replace("#SECONDO4#", "");
        }

        /**
         * Check pizza
         */
        if (null != pizze && !pizze.isEmpty()) {
            mail = mail.replace("PRESENZAPIZZE", "");


            /**
             * Replace pizza
             */
            if (1 <= pizze.size()) {
                String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", pizze.get(0).getNome());
                contenuto = contenuto.replace("#PREZZO#", pizze.get(0).getPrezzo().replace("€", "&euro;"));
                mail = mail.replace("#PIZZA1#", contenuto);
            } else {
                mail = mail.replace("#PIZZA1#", "");
            }
            if (2 <= pizze.size()) {
                String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", pizze.get(1).getNome());
                contenuto = contenuto.replace("#PREZZO#", pizze.get(1).getPrezzo().replace("€", "&euro;"));
                mail = mail.replace("#PIZZA2#", contenuto);
            } else {
                mail = mail.replace("#PIZZA2#", "");
            }
        } else {
            mail = mail.replace("PRESENZAPIZZE", "display:none;");
        }

        MenuDelGiornoData data = menuDelGiornoDataRepository.getOne(1L);
        data.setValore(dataStr);
        menuDelGiornoDataRepository.save(data);

        try {
            // Recipient's email ID needs to be mentioned.
            List<SubscriberDTO> subscriberDTOS = subscriberService.menuSubscribers();
            String subject = "Menu del giorno " + dataStr;

            mailService.sendMail(subscriberDTOS.stream().map(SubscriberDTO::getMail).collect(Collectors.toList()), subject, mail);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}