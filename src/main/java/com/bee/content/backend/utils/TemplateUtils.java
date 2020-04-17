package com.bee.content.backend.utils;

public class TemplateUtils {

    public static String MAIL_MESSAGE_RESPONSE_TEMPLATE = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html style=\"width:100%;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\">\n" +
            " <head> \n" +
            "  <meta charset=\"UTF-8\"> \n" +
            "  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \n" +
            "  <meta name=\"x-apple-disable-message-reformatting\"> \n" +
            "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \n" +
            "  <meta content=\"telephone=no\" name=\"format-detection\"> \n" +
            "  <title>Nuovo modello di email 2020-01-16</title> \n" +
            "  <!--[if (mso 16)]>\n" +
            "    <style type=\"text/css\">\n" +
            "    a {text-decoration: none;}\n" +
            "    </style>\n" +
            "     \n" +
            "  <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style> \n" +
            "  <!--[if !mso]><!-- --> \n" +
            "  <link href=\"https://fonts.googleapis.com/css?family=Lato:400,400i,700,700i\" rel=\"stylesheet\"> \n" +
            "  <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,400i,700,700i\" rel=\"stylesheet\"> \n" +
            "  <!-- \n" +
            "  <style type=\"text/css\">\n" +
            "@media only screen and (max-width:600px) {p, ul li, ol li, a { font-size:17px!important; line-height:150%!important } h1 { font-size:30px!important; text-align:center; line-height:120%!important } h2 { font-size:26px!important; text-align:left; line-height:120%!important } h3 { font-size:20px!important; text-align:left; line-height:120%!important } h1 a { font-size:30px!important; text-align:center } h2 a { font-size:20px!important; text-align:left } h3 a { font-size:20px!important; text-align:left } .es-menu td a { font-size:16px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:17px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button { font-size:14px!important; display:inline-block!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } .es-desk-menu-hidden { display:table-cell!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } }\n" +
            "#outlook a {\n" +
            "\tpadding:0;\n" +
            "}\n" +
            ".ExternalClass {\n" +
            "\twidth:100%;\n" +
            "}\n" +
            ".ExternalClass,\n" +
            ".ExternalClass p,\n" +
            ".ExternalClass span,\n" +
            ".ExternalClass font,\n" +
            ".ExternalClass td,\n" +
            ".ExternalClass div {\n" +
            "\tline-height:100%;\n" +
            "}\n" +
            ".es-button {\n" +
            "\tmso-style-priority:100!important;\n" +
            "\ttext-decoration:none!important;\n" +
            "\ttransition:all 100ms ease-in;\n" +
            "}\n" +
            "a[x-apple-data-detectors] {\n" +
            "\tcolor:inherit!important;\n" +
            "\ttext-decoration:none!important;\n" +
            "\tfont-size:inherit!important;\n" +
            "\tfont-family:inherit!important;\n" +
            "\tfont-weight:inherit!important;\n" +
            "\tline-height:inherit!important;\n" +
            "}\n" +
            ".es-button:hover {\n" +
            "\tbackground:#555555!important;\n" +
            "\tborder-color:#555555!important;\n" +
            "}\n" +
            ".es-desk-hidden {\n" +
            "\tdisplay:none;\n" +
            "\tfloat:left;\n" +
            "\toverflow:hidden;\n" +
            "\twidth:0;\n" +
            "\tmax-height:0;\n" +
            "\tline-height:0;\n" +
            "\tmso-hide:all;\n" +
            "}\n" +
            "</style> \n" +
            " </head> \n" +
            " <body style=\"width:100%;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\"> \n" +
            "  <div class=\"es-wrapper-color\" style=\"background-color:#FEFDFD;\"> \n" +
            "   <!--[if gte mso 9]>\n" +
            "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
            "\t\t\t\t<v:fill type=\"tile\" color=\"#fefdfd\"></v:fill>\n" +
            "\t\t\t</v:background>\n" +
            "\t\t \n" +
            "   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;\"> \n" +
            "     <tr style=\"border-collapse:collapse;\"> \n" +
            "      <td valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top;\"> \n" +
            "         <tr style=\"border-collapse:collapse;\"> \n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "           <table class=\"es-header-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\" width=\"790\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\"> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td style=\"Margin:0;padding-top:10px;padding-bottom:10px;padding-left:40px;padding-right:40px;background-color:#1D1C1C;\" bgcolor=\"#1d1c1c\" align=\"left\"> \n" +
            "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"710\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:18px;color:#FFFFFF;\"><strong>RISTORANTE PIZZERIA MONOPOLI</strong></p></td> \n" +
            "                     </tr> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:10px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:15px;color:#999999;\">Via Piero Della Francesca 68, 20154 Milano (MI)</p></td> \n" +
            "                     </tr> \n" +
            "                   </table></td> \n" +
            "                 </tr> \n" +
            "               </table></td> \n" +
            "             </tr> \n" +
            "           </table></td> \n" +
            "         </tr> \n" +
            "       </table> \n" +
            "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
            "         <tr style=\"border-collapse:collapse;\"> \n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#040404;\" width=\"790\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#040404\" align=\"center\"> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"padding:40px;Margin:0;background-image:url(http://www.ristorantemonopoli.com/images/mail_template_clienti/55121579621498204.png);background-position:40% 100%;background-repeat:no-repeat;\" background=\"http://www.ristorantemonopoli.com/images/mail_template_clienti/55121579621498204.png\"> \n" +
            "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"710\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px;padding-top:40px;\"><h1 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:30px;font-style:normal;font-weight:bold;color:#FFFFFF;\">CIAO #NOME#!</h1></td> \n" +
            "                     </tr> \n" +
            "                   </table></td> \n" +
            "                 </tr> \n" +
            "               </table></td> \n" +
            "             </tr> \n" +
            "           </table></td> \n" +
            "         </tr> \n" +
            "       </table> \n" +
            "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
            "         <tr style=\"border-collapse:collapse;\"> \n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"790\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\"> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:40px;padding-right:40px;\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"710\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:20px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#1E0504;\"><strong>DOMANDA</strong></p></td> \n" +
            "                     </tr> \n" +
            "                   </table></td> \n" +
            "                 </tr> \n" +
            "               </table></td> \n" +
            "             </tr> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"790\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:25px;padding-bottom:25px;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:23px;color:#555555;\">#DOMANDA#</p></td> \n" +
            "                     </tr> \n" +
            "                   </table></td> \n" +
            "                 </tr> \n" +
            "               </table></td> \n" +
            "             </tr> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:40px;padding-right:40px;\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"710\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:20px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#230404;\"><strong>RISPOSTA</strong></p></td> \n" +
            "                     </tr> \n" +
            "                   </table></td> \n" +
            "                 </tr> \n" +
            "               </table></td> \n" +
            "             </tr> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"790\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"left\" style=\"padding:0;Margin:0;padding-top:25px;padding-bottom:25px;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:23px;color:#555555;text-align:center;\">#RISPOSTA#</p></td> \n" +
            "                     </tr> \n" +
            "                   </table></td> \n" +
            "                 </tr> \n" +
            "               </table></td> \n" +
            "             </tr> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:40px;padding-right:40px;\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"710\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"left\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:23px;color:#555555;\"><br></p></td> \n" +
            "                     </tr> \n" +
            "                   </table></td> \n" +
            "                 </tr> \n" +
            "               </table></td> \n" +
            "             </tr> \n" +
            "           </table></td> \n" +
            "         </tr> \n" +
            "       </table> \n" +
            "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
            "         <tr style=\"border-collapse:collapse;\"> \n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#292828;\" width=\"790\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#292828\" align=\"center\"> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"Margin:0;padding-top:20px;padding-bottom:20px;padding-left:40px;padding-right:40px;background-image:url(http://www.ristorantemonopoli.com/images/mail_template_clienti/55121579621498204.png);background-position:left top;background-repeat:no-repeat;\" background=\"http://www.ristorantemonopoli.com/images/mail_template_clienti/55121579621498204.png\"> \n" +
            "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"710\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "                       <table class=\"es-table-not-adapt es-social\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                         <tr style=\"border-collapse:collapse;\"> \n" +
            "                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px;\"><a href=\"https://www.facebook.com/pages/category/Pizza-Place/Ristorante-Pizzeria-Monopoli-800281153361742/\"><img title=\"Facebook\" src=\"http://www.ristorantemonopoli.com/images/mail_template_clienti/facebook-circle-white.png\" alt=\"Fb\" width=\"24\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;\"></a></td> \n" +
            "                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"><a href=\"https://instagram.com/ristorantemonopoli\"><img title=\"Instagram\" src=\"http://www.ristorantemonopoli.com/images/mail_template_clienti/instagram-circle-white.png\" alt=\"Inst\" width=\"24\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;\"></a></td> \n" +
            "                         </tr> \n" +
            "                       </table></td> \n" +
            "                     </tr> \n" +
            "                   </table></td> \n" +
            "                 </tr> \n" +
            "               </table></td> \n" +
            "             </tr> \n" +
            "           </table></td> \n" +
            "         </tr> \n" +
            "       </table> \n" +
            "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top;\"> \n" +
            "         <tr style=\"border-collapse:collapse;\"> \n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "           <table class=\"es-footer-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\" width=\"790\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\"> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"Margin:0;padding-top:40px;padding-bottom:40px;padding-left:40px;padding-right:40px;\"> \n" +
            "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"710\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:18px;color:#666666;\">Via Piero Della Francesca 68, 20154 Milano (MI)</p></td> \n" +
            "                     </tr> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:18px;color:#666666;\">Questa mail è stata inviata da www.ristorantemonopoli.com</p></td> \n" +
            "                     </tr> \n" +
            "                   </table></td> \n" +
            "                 </tr> \n" +
            "               </table></td> \n" +
            "             </tr> \n" +
            "           </table></td> \n" +
            "         </tr> \n" +
            "       </table> \n" +
            "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
            "         <tr style=\"border-collapse:collapse;\"> \n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;\" width=\"790\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px;\"> \n" +
            "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"750\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"left\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:23px;color:#555555;\"></p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:23px;color:#555555;\"><br></p></td> \n" +
            "                     </tr> \n" +
            "                   </table></td> \n" +
            "                 </tr> \n" +
            "               </table></td> \n" +
            "             </tr> \n" +
            "           </table></td> \n" +
            "         </tr> \n" +
            "       </table></td> \n" +
            "     </tr> \n" +
            "   </table> \n" +
            "  </div>  \n" +
            " </body>\n" +
            "</html>";

    public static String MAIL_DAYMENU_CUSTOMER_TEMPLATE = "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
            "         <tr style=\"border-collapse:collapse;\"> \n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\"> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:40px;padding-right:40px;\"> \n" +
            "               <!--[if mso]><table width=\"520\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"250\" valign=\"top\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left;\"> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"250\" class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"left\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:23px;color:#555555;\">#NOME#</p></td> \n" +
            "                     </tr> \n" +
            "                   </table></td> \n" +
            "                 </tr> \n" +
            "               </table> \n" +
            "               <!--[if mso]></td><td width=\"20\"></td><td width=\"250\" valign=\"top\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right;\"> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"250\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"right\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:23px;color:#555555;\">#PREZZO#</p></td> \n" +
            "                     </tr> \n" +
            "                   </table></td> \n" +
            "                 </tr> \n" +
            "               </table> \n" +
            "               <!--[if mso]></td></tr></table></td> \n" +
            "             </tr> \n" +
            "           </table></td> \n" +
            "         </tr> \n" +
            "       </table> ";

    public static String BASE_TEMPLATE_CLIENTI = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
            "   \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html style=\"width:100%;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\">\n" +
            "   <head>\n" +
            "      <meta charset=\"UTF-8\">\n" +
            "      <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
            "      <meta name=\"x-apple-disable-message-reformatting\">\n" +
            "      <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "      <meta content=\"telephone=no\" name=\"format-detection\">\n" +
            "      <title>Nuovo modello di email 2020-01-16</title>\n" +
            "      <!--[if (mso 16)]>\n" +
            "      <style type=\"text/css\">\n" +
            "         a {\n" +
            "         text-decoration: none;\n" +
            "         }\n" +
            "      </style>\n" +
            "      \n" +
            "      <!--[if gte mso 9]>\n" +
            "      <style>sup {\n" +
            "         font-size: 100% !important;\n" +
            "         }\n" +
            "      </style>\n" +
            "      \n" +
            "      <!--[if !mso]><!-- -->\n" +
            "      <link href=\"https://fonts.googleapis.com/css?family=Lato:400,400i,700,700i\" rel=\"stylesheet\">\n" +
            "      <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,400i,700,700i\" rel=\"stylesheet\">\n" +
            "      <!--\n" +
            "      <style type=\"text/css\">\n" +
            "         @media only screen and (max-width: 600px) {\n" +
            "         p, ul li, ol li, a {\n" +
            "         font-size: 17px !important;\n" +
            "         line-height: 150% !important\n" +
            "         }\n" +
            "         h1 {\n" +
            "         font-size: 30px !important;\n" +
            "         text-align: center;\n" +
            "         line-height: 120% !important\n" +
            "         }\n" +
            "         h2 {\n" +
            "         font-size: 26px !important;\n" +
            "         text-align: left;\n" +
            "         line-height: 120% !important\n" +
            "         }\n" +
            "         h3 {\n" +
            "         font-size: 20px !important;\n" +
            "         text-align: left;\n" +
            "         line-height: 120% !important\n" +
            "         }\n" +
            "         h1 a {\n" +
            "         font-size: 30px !important;\n" +
            "         text-align: center\n" +
            "         }\n" +
            "         h2 a {\n" +
            "         font-size: 20px !important;\n" +
            "         text-align: left\n" +
            "         }\n" +
            "         h3 a {\n" +
            "         font-size: 20px !important;\n" +
            "         text-align: left\n" +
            "         }\n" +
            "         .es-menu td a {\n" +
            "         font-size: 16px !important\n" +
            "         }\n" +
            "         .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a {\n" +
            "         font-size: 16px !important\n" +
            "         }\n" +
            "         .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a {\n" +
            "         font-size: 17px !important\n" +
            "         }\n" +
            "         .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a {\n" +
            "         font-size: 12px !important\n" +
            "         }\n" +
            "         *[class=\"gmail-fix\"] {\n" +
            "         display: none !important\n" +
            "         }\n" +
            "         .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 {\n" +
            "         text-align: center !important\n" +
            "         }\n" +
            "         .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 {\n" +
            "         text-align: right !important\n" +
            "         }\n" +
            "         .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 {\n" +
            "         text-align: left !important\n" +
            "         }\n" +
            "         .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img {\n" +
            "         display: inline !important\n" +
            "         }\n" +
            "         .es-button-border {\n" +
            "         display: inline-block !important\n" +
            "         }\n" +
            "         a.es-button {\n" +
            "         font-size: 14px !important;\n" +
            "         display: inline-block !important;\n" +
            "         border-width: 15px 25px 15px 25px !important\n" +
            "         }\n" +
            "         .es-btn-fw {\n" +
            "         border-width: 10px 0px !important;\n" +
            "         text-align: center !important\n" +
            "         }\n" +
            "         .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right {\n" +
            "         width: 100% !important\n" +
            "         }\n" +
            "         .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header {\n" +
            "         width: 100% !important;\n" +
            "         max-width: 600px !important\n" +
            "         }\n" +
            "         .es-adapt-td {\n" +
            "         display: block !important;\n" +
            "         width: 100% !important\n" +
            "         }\n" +
            "         .adapt-img {\n" +
            "         width: 100% !important;\n" +
            "         height: auto !important\n" +
            "         }\n" +
            "         .es-m-p0 {\n" +
            "         padding: 0px !important\n" +
            "         }\n" +
            "         .es-m-p0r {\n" +
            "         padding-right: 0px !important\n" +
            "         }\n" +
            "         .es-m-p0l {\n" +
            "         padding-left: 0px !important\n" +
            "         }\n" +
            "         .es-m-p0t {\n" +
            "         padding-top: 0px !important\n" +
            "         }\n" +
            "         .es-m-p0b {\n" +
            "         padding-bottom: 0 !important\n" +
            "         }\n" +
            "         .es-m-p20b {\n" +
            "         padding-bottom: 20px !important\n" +
            "         }\n" +
            "         .es-mobile-hidden, .es-hidden {\n" +
            "         display: none !important\n" +
            "         }\n" +
            "         .es-desk-hidden {\n" +
            "         display: table-row !important;\n" +
            "         width: auto !important;\n" +
            "         overflow: visible !important;\n" +
            "         float: none !important;\n" +
            "         max-height: inherit !important;\n" +
            "         line-height: inherit !important\n" +
            "         }\n" +
            "         .es-desk-menu-hidden {\n" +
            "         display: table-cell !important\n" +
            "         }\n" +
            "         table.es-table-not-adapt, .esd-block-html table {\n" +
            "         width: auto !important\n" +
            "         }\n" +
            "         table.es-social {\n" +
            "         display: inline-block !important\n" +
            "         }\n" +
            "         table.es-social td {\n" +
            "         display: inline-block !important\n" +
            "         }\n" +
            "         }\n" +
            "         #outlook a {\n" +
            "         padding: 0;\n" +
            "         }\n" +
            "         .ExternalClass {\n" +
            "         width: 100%;\n" +
            "         }\n" +
            "         .ExternalClass,\n" +
            "         .ExternalClass p,\n" +
            "         .ExternalClass span,\n" +
            "         .ExternalClass font,\n" +
            "         .ExternalClass td,\n" +
            "         .ExternalClass div {\n" +
            "         line-height: 100%;\n" +
            "         }\n" +
            "         .es-button {\n" +
            "         mso-style-priority: 100 !important;\n" +
            "         text-decoration: none !important;\n" +
            "         transition: all 100ms ease-in;\n" +
            "         }\n" +
            "         a[x-apple-data-detectors] {\n" +
            "         color: inherit !important;\n" +
            "         text-decoration: none !important;\n" +
            "         font-size: inherit !important;\n" +
            "         font-family: inherit !important;\n" +
            "         font-weight: inherit !important;\n" +
            "         line-height: inherit !important;\n" +
            "         }\n" +
            "         .es-button:hover {\n" +
            "         background: #555555 !important;\n" +
            "         border-color: #555555 !important;\n" +
            "         }\n" +
            "         .es-desk-hidden {\n" +
            "         display: none;\n" +
            "         float: left;\n" +
            "         overflow: hidden;\n" +
            "         width: 0;\n" +
            "         max-height: 0;\n" +
            "         line-height: 0;\n" +
            "         mso-hide: all;\n" +
            "         }\n" +
            "      </style>\n" +
            "   </head>\n" +
            "   <body style=\"width:100%;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\">\n" +
            "      <div class=\"es-wrapper-color\" style=\"background-color:#F1F1F1;\">\n" +
            "         <!--[if gte mso 9]>\n" +
            "         <v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
            "            <v:fill type=\"tile\" color=\"#f1f1f1\"></v:fill>\n" +
            "         </v:background>\n" +
            "         \n" +
            "         <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;\">\n" +
            "         <tr style=\"border-collapse:collapse;\">\n" +
            "            <td valign=\"top\" style=\"padding:0;Margin:0;\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header\" align=\"center\"\n" +
            "                  style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top;\">\n" +
            "                  <tr style=\"border-collapse:collapse;\">\n" +
            "                     <td align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "                        <table class=\"es-header-body\"\n" +
            "                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\"\n" +
            "                           width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\">\n" +
            "                           <tr style=\"border-collapse:collapse;\">\n" +
            "                              <td style=\"Margin:0;padding-top:10px;padding-bottom:10px;padding-left:40px;padding-right:40px;background-color:#1D1C1C;\"\n" +
            "                                 bgcolor=\"#1d1c1c\" align=\"left\">\n" +
            "                                 <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                                    style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                    <tr style=\"border-collapse:collapse;\">\n" +
            "                                       <td width=\"520\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "                                          <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                                             style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                             <tr style=\"border-collapse:collapse;\">\n" +
            "                                                <td align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "                                                   <p\n" +
            "                                                      style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:18px;color:#FFFFFF;\">\n" +
            "                                                      <strong>RISTORANTE PIZZERIA MONOPOLI</strong>\n" +
            "                                                   </p>\n" +
            "                                                </td>\n" +
            "                                             </tr>\n" +
            "                                             <tr style=\"border-collapse:collapse;\">\n" +
            "                                                <td align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "                                                   <p\n" +
            "                                                      style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:10px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:15px;color:#999999;\">\n" +
            "                                                      Via Piero Della Francesca 68, 20154 Milano (MI)\n" +
            "                                                   </p>\n" +
            "                                                </td>\n" +
            "                                             </tr>\n" +
            "                                          </table>\n" +
            "                                       </td>\n" +
            "                                    </tr>\n" +
            "                                 </table>\n" +
            "                              </td>\n" +
            "                           </tr>\n" +
            "                        </table>\n" +
            "                     </td>\n" +
            "                  </tr>\n" +
            "               </table>\n" +
            "               <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
            "                  style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\">\n" +
            "                  <tr style=\"border-collapse:collapse;\">\n" +
            "                     <td align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "                        <table class=\"es-content-body\"\n" +
            "                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#040404;\"\n" +
            "                           width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#040404\" align=\"center\">\n" +
            "                           <tr style=\"border-collapse:collapse;\">\n" +
            "                              <td align=\"left\"\n" +
            "                                 style=\"padding:40px;Margin:0;background-image:url(http://www.ristorantemonopoli.com/images/mail_template_clienti/55121579621498204.png);background-position:40% 100%;background-repeat:no-repeat;\"\n" +
            "                                 background=\"http://www.ristorantemonopoli.com/images/mail_template_clienti/55121579621498204.png\">\n" +
            "                                 <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                                    style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                    <tr style=\"border-collapse:collapse;\">\n" +
            "                                       <td width=\"520\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "                                          <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                                             style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                             <tr style=\"border-collapse:collapse;\">\n" +
            "                                                <td align=\"center\"\n" +
            "                                                   style=\"padding:0;Margin:0;padding-bottom:10px;padding-top:40px;\">\n" +
            "                                                   <h1 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:30px;font-style:normal;font-weight:bold;color:#FFFFFF;\">\n" +
            "                                                      MENU' DEL GIORNO\n" +
            "                                                   </h1>\n" +
            "                                                </td>\n" +
            "                                             </tr>\n" +
            "                                             <tr style=\"border-collapse:collapse;\">\n" +
            "                                                <td align=\"center\"\n" +
            "                                                   style=\"padding:0;Margin:0;padding-bottom:10px;\">\n" +
            "                                                   <h1\n" +
            "                                                      style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:30px;font-style:normal;font-weight:bold;color:#FFFFFF;\">\n" +
            "                                                      #DATA\n" +
            "                                                   </h1>\n" +
            "                                                </td>\n" +
            "                                             </tr>\n" +
            "                                          </table>\n" +
            "                                       </td>\n" +
            "                                    </tr>\n" +
            "                                 </table>\n" +
            "                              </td>\n" +
            "                           </tr>\n" +
            "                        </table>\n" +
            "                     </td>\n" +
            "                  </tr>\n" +
            "               </table>\n" +
            "               <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
            "                  style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\">\n" +
            "         <tr style=\"border-collapse:collapse;\">\n" +
            "            <td align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "               <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\"\n" +
            "                  align=\"center\"\n" +
            "                  style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\">\n" +
            "                  <tr style=\"border-collapse:collapse;\">\n" +
            "                     <td align=\"left\"\n" +
            "                        style=\"padding:0;Margin:0;padding-top:40px;padding-left:40px;padding-right:40px;\">\n" +
            "                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                           <tr style=\"border-collapse:collapse;\">\n" +
            "                              <td width=\"520\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "                                 <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                                    style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                    <tr style=\"border-collapse:collapse;\">\n" +
            "                                       <td class=\"es-m-txt-c\" align=\"left\"\n" +
            "                                          style=\"padding:0;Margin:0;padding-top:5px;padding-bottom:15px;\">\n" +
            "                                          <h2 style=\"Margin:0;line-height:24px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:20px;font-style:normal;font-weight:bold;color:#333333;text-align:center;\">\n" +
            "                                             PRIMI\n" +
            "                                          </h2>\n" +
            "                                       </td>\n" +
            "                                    </tr>\n" +
            "                                 </table>\n" +
            "                              </td>\n" +
            "                           </tr>\n" +
            "                        </table>\n" +
            "                     </td>\n" +
            "                  </tr>\n" +
            "               </table>\n" +
            "               <!-- ITERATE OVER PRIMI -->\n" +
            "               #PRIMO1#\n" +
            "               #PRIMO2#\n" +
            "               #PRIMO3#\n" +
            "               #PRIMO4#\n" +
            "               #PRIMO5#\n" +
            "               <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
            "                  style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\">\n" +
            "         <tr style=\"border-collapse:collapse;\">\n" +
            "            <td align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "               <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                  bgcolor=\"#ffffff\" align=\"center\"\n" +
            "                  style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\">\n" +
            "                  <tr style=\"border-collapse:collapse;\">\n" +
            "                     <td align=\"left\"\n" +
            "                        style=\"padding:0;Margin:0;padding-top:40px;padding-left:40px;padding-right:40px;\">\n" +
            "                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                           <tr style=\"border-collapse:collapse;\">\n" +
            "                              <td width=\"520\" valign=\"top\" align=\"center\"\n" +
            "                                 style=\"padding:0;Margin:0;\">\n" +
            "                                 <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                                    style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                    <tr style=\"border-collapse:collapse;\">\n" +
            "                                       <td class=\"es-m-txt-c\" align=\"left\"\n" +
            "                                          style=\"padding:0;Margin:0;padding-top:5px;padding-bottom:15px;\">\n" +
            "                                          <h2 style=\"Margin:0;line-height:24px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:20px;font-style:normal;font-weight:bold;color:#333333;text-align:center;\">\n" +
            "                                             SECONDI\n" +
            "                                          </h2>\n" +
            "                                       </td>\n" +
            "                                    </tr>\n" +
            "                                 </table>\n" +
            "                              </td>\n" +
            "                           </tr>\n" +
            "                        </table>\n" +
            "                     </td>\n" +
            "                  </tr>\n" +
            "               </table>\n" +
            "               <!-- ITERATE OVER PRIMI -->\n" +
            "               #SECONDO1#\n" +
            "               #SECONDO2#\n" +
            "               #SECONDO3#\n" +
            "               #SECONDO4#\n" +
            "               <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
            "                  style=\"PRESENZAPIZZE mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\">\n" +
            "                  <tr style=\"border-collapse:collapse;\">\n" +
            "                     <td align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "                        <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\"\n" +
            "                           cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\"\n" +
            "                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\">\n" +
            "                           <tr style=\"border-collapse:collapse;\">\n" +
            "                              <td align=\"left\"\n" +
            "                                 style=\"padding:0;Margin:0;padding-top:40px;padding-left:40px;padding-right:40px;\">\n" +
            "                                 <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                                    style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                    <tr style=\"border-collapse:collapse;\">\n" +
            "                                       <td width=\"520\" valign=\"top\" align=\"center\"\n" +
            "                                          style=\"padding:0;Margin:0;\">\n" +
            "                                          <table width=\"100%\" cellspacing=\"0\"\n" +
            "                                             cellpadding=\"0\"\n" +
            "                                             style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                             <tr style=\"border-collapse:collapse;\">\n" +
            "                                                <td class=\"es-m-txt-c\" align=\"left\"\n" +
            "                                                   style=\"padding:0;Margin:0;padding-top:5px;padding-bottom:15px;\">\n" +
            "                                                   <h2 style=\"Margin:0;line-height:24px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:20px;font-style:normal;font-weight:bold;color:#333333;text-align:center;\">\n" +
            "                                                      PIZZE\n" +
            "                                                   </h2>\n" +
            "                                                </td>\n" +
            "                                             </tr>\n" +
            "                                          </table>\n" +
            "                                       </td>\n" +
            "                                    </tr>\n" +
            "                                 </table>\n" +
            "                              </td>\n" +
            "                           </tr>\n" +
            "                        </table>\n" +
            "                        <!-- ITERATE OVER PRIMI -->\n" +
            "                        #PIZZA1#\n" +
            "                        #PIZZA2#\n" +
            "                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                           align=\"center\"\n" +
            "                           style=\"margin-top:1em; mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\">\n" +
            "                           <tr style=\"border-collapse:collapse;\">\n" +
            "                              <td align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "                                 <table class=\"es-content-body\"\n" +
            "                                    style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#292828;\"\n" +
            "                                    width=\"600\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                                    bgcolor=\"#292828\" align=\"center\">\n" +
            "                                    <tr style=\"border-collapse:collapse;\">\n" +
            "                                       <td align=\"left\"\n" +
            "                                          style='Margin:0;padding-top:20px;padding-bottom:20px;padding-left:40px;padding-right:40px;background-image:url(\"http://www.ristorantemonopoli.com/images/mail_template_clienti/55121579621498204.png\");background-position:left top;background-repeat:no-repeat;'\n" +
            "                                          background=\"http://www.ristorantemonopoli.com/images/mail_template_clienti/55121579621498204.png\">\n" +
            "                                          <table width=\"100%\" cellspacing=\"0\"\n" +
            "                                             cellpadding=\"0\"\n" +
            "                                             style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                             <tr style=\"border-collapse:collapse;\">\n" +
            "                                                <td width=\"520\" valign=\"top\"\n" +
            "                                                   align=\"center\"\n" +
            "                                                   style=\"padding:0;Margin:0;\">\n" +
            "                                                   <table width=\"100%\"\n" +
            "                                                      cellspacing=\"0\"\n" +
            "                                                      cellpadding=\"0\"\n" +
            "                                                      style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                                      <tr style=\"border-collapse:collapse;\">\n" +
            "                                                         <td align=\"center\"\n" +
            "                                                            style=\"padding:0;Margin:0;\">\n" +
            "                                                            <table class=\"es-table-not-adapt es-social\"\n" +
            "                                                               cellspacing=\"0\"\n" +
            "                                                               cellpadding=\"0\"\n" +
            "                                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                                               <tr style=\"border-collapse:collapse;\">\n" +
            "                                                                  <td valign=\"top\"\n" +
            "                                                                     align=\"center\"\n" +
            "                                                                     style=\"padding:0;Margin:0;padding-right:10px;\">\n" +
            "                                                                     <a href=\"https://www.facebook.com/pages/category/Pizza-Place/Ristorante-Pizzeria-Monopoli-800281153361742/\"><img\n" +
            "                                                                        title=\"Facebook\"\n" +
            "                                                                        src=\"http://www.ristorantemonopoli.com/images/mail_template_clienti/facebook-circle-white.png\"\n" +
            "                                                                        alt=\"Fb\"\n" +
            "                                                                        width=\"24\"\n" +
            "                                                                        height=\"24\"\n" +
            "                                                                        style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;\"></a>\n" +
            "                                                                  </td>\n" +
            "                                                                  <td valign=\"top\"\n" +
            "                                                                     align=\"center\"\n" +
            "                                                                     style=\"padding:0;Margin:0;\">\n" +
            "                                                                     <a href=\"https://instagram.com/ristorantemonopoli\"><img\n" +
            "                                                                        title=\"Instagram\"\n" +
            "                                                                        src=\"http://www.ristorantemonopoli.com/images/mail_template_clienti/instagram-circle-white.png\"\n" +
            "                                                                        alt=\"Inst\"\n" +
            "                                                                        width=\"24\"\n" +
            "                                                                        height=\"24\"\n" +
            "                                                                        style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;\"></a>\n" +
            "                                                                  </td>\n" +
            "                                                               </tr>\n" +
            "                                                            </table>\n" +
            "                                                         </td>\n" +
            "                                                      </tr>\n" +
            "                                                   </table>\n" +
            "                                                </td>\n" +
            "                                             </tr>\n" +
            "                                          </table>\n" +
            "                                       </td>\n" +
            "                                    </tr>\n" +
            "                                 </table>\n" +
            "                              </td>\n" +
            "                           </tr>\n" +
            "                        </table>\n" +
            "                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\"\n" +
            "                           align=\"center\"\n" +
            "                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top;\">\n" +
            "                           <tr style=\"border-collapse:collapse;\">\n" +
            "                              <td align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "                                 <table class=\"es-footer-body\"\n" +
            "                                    style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\"\n" +
            "                                    width=\"600\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                                    bgcolor=\"#ffffff\" align=\"center\">\n" +
            "                                    <tr style=\"border-collapse:collapse;\">\n" +
            "                                       <td align=\"left\"\n" +
            "                                          style=\"Margin:0;padding-top:40px;padding-bottom:40px;padding-left:40px;padding-right:40px;\">\n" +
            "                                          <table width=\"100%\" cellspacing=\"0\"\n" +
            "                                             cellpadding=\"0\"\n" +
            "                                             style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                             <tr style=\"border-collapse:collapse;\">\n" +
            "                                                <td width=\"520\" valign=\"top\"\n" +
            "                                                   align=\"center\"\n" +
            "                                                   style=\"padding:0;Margin:0;\">\n" +
            "                                                   <table width=\"100%\"\n" +
            "                                                      cellspacing=\"0\"\n" +
            "                                                      cellpadding=\"0\"\n" +
            "                                                      style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                                      <tr style=\"border-collapse:collapse;\">\n" +
            "                                                         <td align=\"center\"\n" +
            "                                                            style=\"padding:0;Margin:0;padding-bottom:10px;\">\n" +
            "                                                            <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:18px;color:#666666;\">\n" +
            "                                                               Via Piero Della\n" +
            "                                                               Francesca 68,\n" +
            "                                                               20154 Milano\n" +
            "                                                               (MI)\n" +
            "                                                            </p>\n" +
            "                                                         </td>\n" +
            "                                                      </tr>\n" +
            "                                                      <tr style=\"border-collapse:collapse;\">\n" +
            "                                                         <td align=\"center\"\n" +
            "                                                            style=\"padding:0;Margin:0;padding-bottom:10px;\">\n" +
            "                                                            <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:18px;color:#666666;\">\n" +
            "                                                               Questa mail è\n" +
            "                                                               stata inviata da\n" +
            "                                                               Ristorante\n" +
            "                                                               Pizzeria\n" +
            "                                                               Monopoli.\n" +
            "                                                            </p>\n" +
            "                                                         </td>\n" +
            "                                                      </tr>\n" +
            "                                                      <tr style=\"border-collapse:collapse;\">\n" +
            "                                                         <td align=\"center\"\n" +
            "                                                            style=\"padding:0;Margin:0;padding-bottom:10px;\">\n" +
            "                                                            <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:18px;color:#666666;\">\n" +
            "                                                               <a target=\"_blank\"\n" +
            "                                                                  class=\"unsubscribe\"\n" +
            "                                                                  href=\"\"\n" +
            "                                                                  style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;font-size:12px;text-decoration:underline;color:#666666;\">Unsubscribe</a>\n" +
            "                                                            </p>\n" +
            "                                                         </td>\n" +
            "                                                      </tr>\n" +
            "                                                   </table>\n" +
            "                                                </td>\n" +
            "                                             </tr>\n" +
            "                                          </table>\n" +
            "                                       </td>\n" +
            "                                    </tr>\n" +
            "                                 </table>\n" +
            "                              </td>\n" +
            "                           </tr>\n" +
            "                        </table>\n" +
            "                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                           align=\"center\"\n" +
            "                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\">\n" +
            "                           <tr style=\"border-collapse:collapse;\">\n" +
            "                              <td align=\"center\" style=\"padding:0;Margin:0;\">\n" +
            "                                 <table class=\"es-content-body\"\n" +
            "                                    style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;\"\n" +
            "                                    width=\"600\" cellspacing=\"0\" cellpadding=\"0\"\n" +
            "                                    align=\"center\">\n" +
            "                                    <tr style=\"border-collapse:collapse;\">\n" +
            "                                       <td align=\"left\"\n" +
            "                                          style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px;\">\n" +
            "                                          <table width=\"100%\" cellspacing=\"0\"\n" +
            "                                             cellpadding=\"0\"\n" +
            "                                             style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                             <tr style=\"border-collapse:collapse;\">\n" +
            "                                                <td width=\"560\" valign=\"top\"\n" +
            "                                                   align=\"center\"\n" +
            "                                                   style=\"padding:0;Margin:0;\">\n" +
            "                                                   <table width=\"100%\"\n" +
            "                                                      cellspacing=\"0\"\n" +
            "                                                      cellpadding=\"0\"\n" +
            "                                                      style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">\n" +
            "                                                      <tr style=\"border-collapse:collapse;\">\n" +
            "                                                         <td align=\"left\"\n" +
            "                                                            style=\"padding:0;Margin:0;\">\n" +
            "                                                            <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:23px;color:#555555;\"></p>\n" +
            "                                                            <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:23px;color:#555555;\">\n" +
            "                                                               <br>\n" +
            "                                                            </p>\n" +
            "                                                         </td>\n" +
            "                                                      </tr>\n" +
            "                                                   </table>\n" +
            "                                                </td>\n" +
            "                                             </tr>\n" +
            "                                          </table>\n" +
            "                                       </td>\n" +
            "                                    </tr>\n" +
            "                                 </table>\n" +
            "                              </td>\n" +
            "                           </tr>\n" +
            "                        </table>\n" +
            "                     </td>\n" +
            "                  </tr>\n" +
            "               </table>\n" +
            "      </div>\n" +
            "   </body>\n" +
            "</html>";
}
