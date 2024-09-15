package comunication;

import appcontroller.AppController;

import java.time.LocalDate;

public class AsignacionCorreo {
    public static String plantillaAsignacion(String nombre, LocalDate fecha, String estadoEnvio, String direccionEntrega, String localidad, String nombreRemitente, String nombreDestinatario){

        return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
               "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
               "<head>\n" +
               "\n" +
               "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
               "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
               "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
               "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
               "  <title></title>\n" +
               "  \n" +
               "    <style type=\"text/css\">\n" +
               "      @media only screen and (min-width: 620px) {\n" +
               "  .u-row {\n" +
               "    width: 600px !important;\n" +
               "  }\n" +
               "  .u-row .u-col {\n" +
               "    vertical-align: top;\n" +
               "  }\n" +
               "\n" +
               "  .u-row .u-col-100 {\n" +
               "    width: 600px !important;\n" +
               "  }\n" +
               "\n" +
               "}\n" +
               "\n" +
               "@media (max-width: 620px) {\n" +
               "  .u-row-container {\n" +
               "    max-width: 100% !important;\n" +
               "    padding-left: 0px !important;\n" +
               "    padding-right: 0px !important;\n" +
               "  }\n" +
               "  .u-row .u-col {\n" +
               "    min-width: 320px !important;\n" +
               "    max-width: 100% !important;\n" +
               "    display: block !important;\n" +
               "  }\n" +
               "  .u-row {\n" +
               "    width: 100% !important;\n" +
               "  }\n" +
               "  .u-col {\n" +
               "    width: 100% !important;\n" +
               "  }\n" +
               "  .u-col > div {\n" +
               "    margin: 0 auto;\n" +
               "  }\n" +
               "}\n" +
               "body {\n" +
               "  margin: 0;\n" +
               "  padding: 0;\n" +
               "}\n" +
               "\n" +
               "table,\n" +
               "tr,\n" +
               "td {\n" +
               "  vertical-align: top;\n" +
               "  border-collapse: collapse;\n" +
               "}\n" +
               "\n" +
               "p {\n" +
               "  margin: 0;\n" +
               "}\n" +
               "\n" +
               ".ie-container table,\n" +
               ".mso-container table {\n" +
               "  table-layout: fixed;\n" +
               "}\n" +
               "\n" +
               "* {\n" +
               "  line-height: inherit;\n" +
               "}\n" +
               "\n" +
               "a[x-apple-data-detectors='true'] {\n" +
               "  color: inherit !important;\n" +
               "  text-decoration: none !important;\n" +
               "}\n" +
               "\n" +
               "table, td { color: #000000; } #u_body a { color: #0000ee; text-decoration: underline; } @media (max-width: 480px) { #u_content_heading_1 .v-font-size { font-size: 35px !important; } #u_content_heading_1 .v-line-height { line-height: 120% !important; } #u_content_image_2 .v-container-padding-padding { padding: 10px !important; } #u_content_image_2 .v-src-width { width: auto !important; } #u_content_image_2 .v-src-max-width { max-width: 44% !important; } #u_content_text_1 .v-container-padding-padding { padding: 30px 10px 0px !important; } #u_content_text_3 .v-container-padding-padding { padding: 10px 10px 60px !important; } #u_content_text_4 .v-container-padding-padding { padding: 10px 10px 60px !important; } }\n" +
               "    </style>\n" +
               "  \n" +
               "  \n" +
               "\n" +
               "<link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Playfair+Display:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
               "\n" +
               "</head>\n" +
               "\n" +
               "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #ecf0f1;color: #000000\">\n" +
               "\n" +
               "  <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #ecf0f1;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
               "  <tbody>\n" +
               "  <tr style=\"vertical-align: top\">\n" +
               "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
               "\n" +
               "    \n" +
               "  \n" +
               "  \n" +
               "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
               "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
               "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
               "\n" +
               "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
               "  <div style=\"background-color: #ffffff;height: 100%;width: 100% !important;\">\n" +
               "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
               "  \n" +
               "<table id=\"u_content_heading_1\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "  <!--[if mso]><table width=\"100%\"><tr><td><![endif]-->\n" +
               "    <h1 class=\"v-line-height v-font-size\" style=\"margin: 0px; line-height: 140%; text-align: center; word-wrap: break-word; font-family: 'Playfair Display',serif; font-size: 30px; font-weight: 400;\"><span><strong>Tienes un envío nuevo</strong></span></h1>\n" +
               "  <!--[if mso]></td></tr></table><![endif]-->\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "<table id=\"u_content_image_2\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
               "  <tr>\n" +
               "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
               "      \n" +
               "      <img align=\"center\" border=\"0\" src=\"https://i.ibb.co/VVm74qQ/image-6.png\" alt=\"image\" title=\"image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 35%;max-width: 203px;\" width=\"203\" class=\"v-src-width v-src-max-width\"/>\n" +
               "      \n" +
               "    </td>\n" +
               "  </tr>\n" +
               "</table>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 0px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
               "  <tr>\n" +
               "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
               "      \n" +
               "      <img align=\"center\" border=\"0\" src=\"https://i.ibb.co/4NvXqqn/image-7.png\" alt=\"image\" title=\"image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 600px;\" width=\"600\" class=\"v-src-width v-src-max-width\"/>\n" +
               "      \n" +
               "    </td>\n" +
               "  </tr>\n" +
               "</table>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 0px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
               "    <tbody>\n" +
               "      <tr style=\"vertical-align: top\">\n" +
               "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
               "          <span>&#160;</span>\n" +
               "        </td>\n" +
               "      </tr>\n" +
               "    </tbody>\n" +
               "  </table>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "<table id=\"u_content_text_1\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 30px 0px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "  <div class=\"v-line-height v-font-size\" style=\"font-size: 14px; line-height: 160%; text-align: justify; word-wrap: break-word;\">\n" +
               "    <p style=\"font-size: 14px; line-height: 160%;\"><strong>Hola "+ nombre +"</strong></p>\n" +
               "<p style=\"font-size: 14px; line-height: 160%;\"> </p>\n" +
               "<p style=\"font-size: 14px; line-height: 160%;\">Te avisamos de que pronto recibirás un envío, ha sido enviado por "+ nombreRemitente + ", a la dirección "+ direccionEntrega + ", " + localidad + ", su fecha de entrega próxima será el "+ fecha + " para el destinatario "+ nombreDestinatario +". Actualmente el envio se encuentra "+ estadoEnvio +".</p>\n" +
               "<p style=\"font-size: 14px; line-height: 160%;\"> </p>\n" +
               "<p style=\"font-size: 14px; line-height: 160%;\">Si necesita hacer alguna modificación no dude en iniciar sesión en nuestra app.</p>\n" +
               "  </div>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "<table id=\"u_content_text_3\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 60px 30px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "  <div class=\"v-line-height v-font-size\" style=\"font-size: 14px; line-height: 160%; text-align: left; word-wrap: break-word;\">\n" +
               "    <p style=\"font-size: 14px; line-height: 160%;\">Un placer,</p>\n" +
               "<p style=\"font-size: 14px; line-height: 160%;\">María Ordóñez, Directora de FernanPaaq.</p>\n" +
               "  </div>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
               "  </div>\n" +
               "</div>\n" +
               "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
               "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
               "    </div>\n" +
               "  </div>\n" +
               "  </div>\n" +
               "  \n" +
               "\n" +
               "\n" +
               "  \n" +
               "  \n" +
               "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
               "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
               "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
               "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
               "      \n" +
               "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
               "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
               "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
               "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
               "  \n" +
               "<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:60px 10px 10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "<div align=\"center\">\n" +
               "  <div style=\"display: table; max-width:187px;\">\n" +
               "  <!--[if (mso)|(IE)]><table width=\"187\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"center\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:187px;\"><tr><![endif]-->\n" +
               "  \n" +
               "    \n" +
               "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
               "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
               "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
               "        <a href=\"https://facebook.com/\" title=\"Facebook\" target=\"_blank\">\n" +
               "          <img src=\"https://i.ibb.co/Sm6NXT7/image-5.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
               "        </a>\n" +
               "      </td></tr>\n" +
               "    </tbody></table>\n" +
               "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
               "    \n" +
               "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
               "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
               "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
               "        <a href=\"https://twitter.com/\" title=\"Twitter\" target=\"_blank\">\n" +
               "          <img src=\"https://i.ibb.co/bQm40sM/image-4.png\" alt=\"Twitter\" title=\"Twitter\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
               "        </a>\n" +
               "      </td></tr>\n" +
               "    </tbody></table>\n" +
               "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
               "    \n" +
               "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
               "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
               "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
               "        <a href=\"https://linkedin.com/\" title=\"LinkedIn\" target=\"_blank\">\n" +
               "          <img src=\"https://i.ibb.co/XXXWf3Q/image-3.png\" alt=\"LinkedIn\" title=\"LinkedIn\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
               "        </a>\n" +
               "      </td></tr>\n" +
               "    </tbody></table>\n" +
               "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
               "    \n" +
               "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\n" +
               "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\n" +
               "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
               "        <a href=\"https://instagram.com/\" title=\"Instagram\" target=\"_blank\">\n" +
               "          <img src=\"https://i.ibb.co/bvD90S2/image-6.png\" alt=\"Instagram\" title=\"Instagram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
               "        </a>\n" +
               "      </td></tr>\n" +
               "    </tbody></table>\n" +
               "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
               "    \n" +
               "    \n" +
               "    <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
               "  </div>\n" +
               "</div>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "<table id=\"u_content_text_4\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 100px 60px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "  <div class=\"v-line-height v-font-size\" style=\"font-size: 14px; line-height: 160%; text-align: center; word-wrap: break-word;\">\n" +
               "    <p style=\"font-size: 14px; line-height: 160%;\">DARSE DE BAJA   |   Política de privacidad  |   Web</p>\n" +
               "<p style=\"font-size: 14px; line-height: 160%;\"> </p>\n" +
               "<p style=\"font-size: 14px; line-height: 160%;\">No nos hacemos responsables de las posibles estafas realizadas en nuestro nombre.</p>\n" +
               "  </div>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
               "  </div>\n" +
               "</div>\n" +
               "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
               "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
               "    </div>\n" +
               "  </div>\n" +
               "  </div>\n" +
               "  \n" +
               "\n" +
               "\n" +
               "  \n" +
               "  \n" +
               "<div class=\"u-row-container\" style=\"padding: 0px;background-color: #ffffff\">\n" +
               "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
               "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
               "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #ffffff;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
               "      \n" +
               "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #ffffff;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
               "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
               "  <div style=\"background-color: #ffffff;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
               "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
               "  \n" +
               "<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
               "  <tr>\n" +
               "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
               "      \n" +
               "      <img align=\"center\" border=\"0\" src=\"https://i.ibb.co/B3MJxhh/logo-fernanpaaq.jpg\" alt=\"image\" title=\"image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 149px;\" width=\"149\" class=\"v-src-width v-src-max-width\"/>\n" +
               "      \n" +
               "    </td>\n" +
               "  </tr>\n" +
               "</table>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
               "  </div>\n" +
               "</div>\n" +
               "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
               "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
               "    </div>\n" +
               "  </div>\n" +
               "  </div>\n" +
               "  \n" +
               "\n" +
               "\n" +
               "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
               "    </td>\n" +
               "  </tr>\n" +
               "  </tbody>\n" +
               "  </table>\n" +
               "  <!--[if mso]></div><![endif]-->\n" +
               "  <!--[if IE]></div><![endif]-->\n" +
               "</body>\n" +
               "\n" +
               "</html>";
    }
}
