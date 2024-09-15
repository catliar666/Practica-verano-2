package comunication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AvisoCorreo {
    public static String generaPlantillaAviso(String nombre, int numSeguimiento, LocalDate fecha, String estadoEnvio, String direccionEntrega, String localidad) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateExpect = fecha.format(formatter);
        if (estadoEnvio.equals("En reparto")) {
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
                   "      @media only screen and (min-width: 670px) {\n" +
                   "  .u-row {\n" +
                   "    width: 650px !important;\n" +
                   "  }\n" +
                   "  .u-row .u-col {\n" +
                   "    vertical-align: top;\n" +
                   "  }\n" +
                   "\n" +
                   "  .u-row .u-col-100 {\n" +
                   "    width: 650px !important;\n" +
                   "  }\n" +
                   "\n" +
                   "}\n" +
                   "\n" +
                   "@media (max-width: 670px) {\n" +
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
                   "table, td { color: #000000; } #u_body a { color: #0000ee; text-decoration: underline; } @media (max-width: 480px) { #u_content_image_6 .v-src-width { width: auto !important; } #u_content_image_6 .v-src-max-width { max-width: 30% !important; } #u_content_button_4 .v-size-width { width: 77% !important; } }\n" +
                   "    </style>\n" +
                   "  \n" +
                   "  \n" +
                   "\n" +
                   "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Raleway:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
                   "\n" +
                   "</head>\n" +
                   "\n" +
                   "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #dd64ec;color: #000000\">\n" +
                   "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
                   "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
                   "  <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #dd64ec;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                   "  <tbody>\n" +
                   "  <tr style=\"vertical-align: top\">\n" +
                   "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                   "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #a9f8c9;\"><![endif]-->\n" +
                   "    \n" +
                   "  \n" +
                   "  \n" +
                   "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                   "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                   "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                   "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:650px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                   "      \n" +
                   "<!--[if (mso)|(IE)]><td align=\"center\" width=\"650\" style=\"width: 650px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                   "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                   "  <div style=\"height: 100%;width: 100% !important;\">\n" +
                   "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                   "  \n" +
                   "<table id=\"u_content_image_6\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                   "  <tr>\n" +
                   "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                   "      \n" +
                   "      <img align=\"center\" border=\"0\" src=\"https://i.ibb.co/B3MJxhh/logo-fernanpaaq.jpg\" alt=\"Logo\" title=\"Logo\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 22%;max-width: 138.6px;\" width=\"138.6\" class=\"v-src-width v-src-max-width\"/>\n" +
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
                   "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                   "  <tr>\n" +
                   "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                   "      \n" +
                   "      <img align=\"center\" border=\"0\" src=\"https://i.ibb.co/vd3DfXj/image-5.png\" alt=\"border\" title=\"border\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 650px;\" width=\"650\" class=\"v-src-width v-src-max-width\"/>\n" +
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
                   "  \n" +
                   "  \n" +
                   "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                   "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f1f3f5;\">\n" +
                   "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                   "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:650px;\"><tr style=\"background-color: #f1f3f5;\"><![endif]-->\n" +
                   "      \n" +
                   "<!--[if (mso)|(IE)]><td align=\"center\" width=\"650\" style=\"width: 650px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                   "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                   "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                   "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                   "  \n" +
                   "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                   "  <tr>\n" +
                   "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                   "      \n" +
                   "      <img align=\"center\" border=\"0\" src=\"https://i.ibb.co/F4hK2tC/image-8.png\" alt=\"Hero Image\" title=\"Hero Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 77%;max-width: 500.5px;\" width=\"500.5\" class=\"v-src-width v-src-max-width\"/>\n" +
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
                   "\n" +
                   "    </div>\n" +
                   "  </div>\n" +
                   "  </div>\n" +
                   "  \n" +
                   "\n" +
                   "\n" +
                   "  \n" +
                   "  \n" +
                   "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                   "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f1f3f5;\">\n" +
                   "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                   "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:650px;\"><tr style=\"background-color: #f1f3f5;\"><![endif]-->\n" +
                   "      \n" +
                   "<!--[if (mso)|(IE)]><td align=\"center\" width=\"650\" style=\"width: 650px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                   "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                   "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                   "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                   "  \n" +
                   "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 10px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "  <!--[if mso]><table width=\"100%\"><tr><td><![endif]-->\n" +
                   "    <h1 style=\"margin: 0px; color: #333333; line-height: 140%; text-align: center; word-wrap: break-word; font-family: 'Open Sans',sans-serif; font-size: 30px; font-weight: 400;\"><span><strong>Su envío está en reparto</strong></span></h1>\n" +
                   "  <!--[if mso]></td></tr></table><![endif]-->\n" +
                   "\n" +
                   "      </td>\n" +
                   "    </tr>\n" +
                   "  </tbody>\n" +
                   "</table>\n" +
                   "\n" +
                   "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 50px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "  <div style=\"font-size: 14px; color: #5e5e5e; line-height: 170%; text-align: center; word-wrap: break-word;\">\n" +
                   "    <p style=\"line-height: 170%;\">El envío " + numSeguimiento + " se encuentra en reparto, llegará en breves momentos, si usted no está en la dirección " + direccionEntrega + ", " + localidad + ", comuníquelo desde nuestra app al conductor que transporta su envio.</p>\n" +
                   "<p style=\"line-height: 170%;\">" + nombre + " esperamos que tenga un buen día.</p>\n" +
                   "  </div>\n" +
                   "\n" +
                   "      </td>\n" +
                   "    </tr>\n" +
                   "  </tbody>\n" +
                   "</table>\n" +
                   "\n" +
                   "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "  <!--[if mso]><table width=\"100%\"><tr><td><![endif]-->\n" +
                   "    <h1 style=\"margin: 0px; color: #722b1d; line-height: 140%; text-align: center; word-wrap: break-word; font-family: 'Open Sans',sans-serif; font-size: 22px; font-weight: 400;\"><span><span>Sigue tu envío a tiempo real.</span></span></h1>\n" +
                   "  <!--[if mso]></td></tr></table><![endif]-->\n" +
                   "\n" +
                   "      </td>\n" +
                   "    </tr>\n" +
                   "  </tbody>\n" +
                   "</table>\n" +
                   "\n" +
                   "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 60px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "  <!--[if mso]><style>.v-button {background: transparent !important;}</style><![endif]-->\n" +
                   "<div align=\"center\">\n" +
                   "  <!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"https://unlayer.com\" style=\"height:64px; v-text-anchor:middle; width:290px;\" arcsize=\"6.5%\"  stroke=\"f\" fillcolor=\"#dd64ec\"><w:anchorlock/><center style=\"color:#ffffff;\"><![endif]-->\n" +
                   "    <a href=\"\" target=\"_blank\" class=\"v-button v-size-width\" style=\"box-sizing: border-box;display: inline-block;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #ffffff; background-color: #dd64ec; border-radius: 4px;-webkit-border-radius: 4px; -moz-border-radius: 4px; width:46%; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;border-top-color: #000000; border-top-style: solid; border-top-width: 0px; border-left-color: #000000; border-left-style: solid; border-left-width: 0px; border-right-color: #000000; border-right-style: solid; border-right-width: 0px; border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0px;font-size: 14px;\">\n" +
                   "      <span style=\"display:block;padding:20px;line-height:120%;\"><span style=\"font-size: 20px; line-height: 24px; font-family: 'Open Sans', sans-serif;\">Seguimiento del envío</span></span>\n" +
                   "    </a>\n" +
                   "    <!--[if mso]></center></v:roundrect><![endif]-->\n" +
                   "</div>\n" +
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
                   "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                   "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                   "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:650px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                   "      \n" +
                   "<!--[if (mso)|(IE)]><td align=\"center\" width=\"650\" style=\"width: 650px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                   "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                   "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                   "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                   "  \n" +
                   "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                   "  <tr>\n" +
                   "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                   "      \n" +
                   "      <img align=\"center\" border=\"0\" src=\"https://i.ibb.co/vd3DfXj/image-5.png\" alt=\"border\" title=\"border\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 650px;\" width=\"650\" class=\"v-src-width v-src-max-width\"/>\n" +
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
                   "  \n" +
                   "  \n" +
                   "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                   "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                   "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                   "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:650px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                   "      \n" +
                   "<!--[if (mso)|(IE)]><td align=\"center\" width=\"650\" style=\"width: 650px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                   "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                   "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                   "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                   "  \n" +
                   "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:50px 10px 0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "  <!--[if mso]><table width=\"100%\"><tr><td><![endif]-->\n" +
                   "    <h1 style=\"margin: 0px; color: #333333; line-height: 140%; text-align: center; word-wrap: break-word; font-family: 'Open Sans',sans-serif; font-size: 40px; font-weight: 400;\"><span>Servicio evaluado por nuestros clientes</span></h1>\n" +
                   "  <!--[if mso]></td></tr></table><![endif]-->\n" +
                   "\n" +
                   "      </td>\n" +
                   "    </tr>\n" +
                   "  </tbody>\n" +
                   "</table>\n" +
                   "\n" +
                   "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "  <div style=\"font-size: 14px; color: #722b1d; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                   "    <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 20px; line-height: 28px;\">★★★★★</span></p>\n" +
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
                   "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f1f3f5;\">\n" +
                   "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                   "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:650px;\"><tr style=\"background-color: #f1f3f5;\"><![endif]-->\n" +
                   "      \n" +
                   "<!--[if (mso)|(IE)]><td align=\"center\" width=\"650\" style=\"width: 650px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                   "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                   "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                   "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                   "  \n" +
                   "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 50px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "  <div style=\"font-size: 14px; color: #787c7c; line-height: 180%; text-align: center; word-wrap: break-word;\">\n" +
                   "    <p style=\"font-size: 14px; line-height: 180%;\"><span style=\"font-family: Raleway, sans-serif; font-size: 16px; line-height: 28.8px;\">Sigue tu envío a tiempo real desde la app de FernanPaaq</span></p>\n" +
                   "  </div>\n" +
                   "\n" +
                   "      </td>\n" +
                   "    </tr>\n" +
                   "  </tbody>\n" +
                   "</table>\n" +
                   "\n" +
                   "<table id=\"u_content_button_4\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 60px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "  <!--[if mso]><style>.v-button {background: transparent !important;}</style><![endif]-->\n" +
                   "<div align=\"center\">\n" +
                   "  <!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"https://unlayer.com\" style=\"height:64px; v-text-anchor:middle; width:290px;\" arcsize=\"6.5%\"  stroke=\"f\" fillcolor=\"#dd64ec\"><w:anchorlock/><center style=\"color:#ffffff;\"><![endif]-->\n" +
                   "    <a href=\"https://unlayer.com\" target=\"_blank\" class=\"v-button v-size-width\" style=\"box-sizing: border-box;display: inline-block;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #ffffff; background-color: #dd64ec; border-radius: 4px;-webkit-border-radius: 4px; -moz-border-radius: 4px; width:46%; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;border-top-color: #000000; border-top-style: solid; border-top-width: 0px; border-left-color: #000000; border-left-style: solid; border-left-width: 0px; border-right-color: #000000; border-right-style: solid; border-right-width: 0px; border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0px;font-size: 14px;\">\n" +
                   "      <span style=\"display:block;padding:20px;line-height:120%;\"><span style=\"font-size: 20px; line-height: 24px; font-family: 'Open Sans', sans-serif;\">Seguimiento del envío</span></span>\n" +
                   "    </a>\n" +
                   "    <!--[if mso]></center></v:roundrect><![endif]-->\n" +
                   "</div>\n" +
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
                   "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #6e6e6e;\">\n" +
                   "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                   "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:650px;\"><tr style=\"background-color: #6e6e6e;\"><![endif]-->\n" +
                   "      \n" +
                   "<!--[if (mso)|(IE)]><td align=\"center\" width=\"650\" style=\"width: 650px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                   "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                   "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                   "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                   "  \n" +
                   "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:50px 10px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "<div align=\"center\">\n" +
                   "  <div style=\"display: table; max-width:187px;\">\n" +
                   "  <!--[if (mso)|(IE)]><table width=\"187\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"center\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:187px;\"><tr><![endif]-->\n" +
                   "  \n" +
                   "    \n" +
                   "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                   "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                   "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                   "        <a href=\"https://linkedin.com/\" title=\"LinkedIn\" target=\"_blank\">\n" +
                   "          <img src=\"images/image-4.png\" alt=\"LinkedIn\" title=\"LinkedIn\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                   "        </a>\n" +
                   "      </td></tr>\n" +
                   "    </tbody></table>\n" +
                   "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                   "    \n" +
                   "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                   "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                   "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                   "        <a href=\"https://instagram.com/\" title=\"Instagram\" target=\"_blank\">\n" +
                   "          <img src=\"https://i.ibb.co/Jk37qKW/image-4.png\" alt=\"Instagram\" title=\"Instagram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                   "        </a>\n" +
                   "      </td></tr>\n" +
                   "    </tbody></table>\n" +
                   "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                   "    \n" +
                   "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                   "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                   "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                   "        <a href=\"https://facebook.com/\" title=\"Facebook\" target=\"_blank\">\n" +
                   "          <img src=\"https://i.ibb.co/CmWbN4c/image-2.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                   "        </a>\n" +
                   "      </td></tr>\n" +
                   "    </tbody></table>\n" +
                   "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                   "    \n" +
                   "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\n" +
                   "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\n" +
                   "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                   "        <a href=\"https://youtube.com/\" title=\"YouTube\" target=\"_blank\">\n" +
                   "          <img src=\"https://i.ibb.co/xGnqjvk/image-3.png\" alt=\"YouTube\" title=\"YouTube\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
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
                   "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                   "  <tbody>\n" +
                   "    <tr>\n" +
                   "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                   "        \n" +
                   "  <div style=\"font-size: 14px; color: #ffffff; line-height: 190%; text-align: center; word-wrap: break-word;\">\n" +
                   "    <p style=\"font-size: 14px; line-height: 190%;\"><span style=\"font-family: Raleway, sans-serif; font-size: 14px; line-height: 26.6px;\">Usted recibe este correo porque está suscrito a nuestras notificaciones</span></p>\n" +
                   "<p style=\"font-size: 14px; line-height: 190%;\"><span style=\"font-family: Raleway, sans-serif; font-size: 14px; line-height: 26.6px;\">©FernanPaaq | Compañia de paquetería</span></p>\n" +
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
                   "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                   "    </td>\n" +
                   "  </tr>\n" +
                   "  </tbody>\n" +
                   "  </table>\n" +
                   "  <!--[if mso]></div><![endif]-->\n" +
                   "  <!--[if IE]></div><![endif]-->\n" +
                   "</body>\n" +
                   "</html>";
    } else return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
               "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
               "<head>\n" +
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
               "@media (max-width: 480px) {\n" +
               "  .hide-mobile {\n" +
               "    max-height: 0px;\n" +
               "    overflow: hidden;\n" +
               "    display: none !important;\n" +
               "  }\n" +
               "}\n" +
               "\n" +
               "table, td { color: #000000; } #u_body a { color: #0000ee; text-decoration: underline; } @media (max-width: 480px) { #u_content_image_1 .v-src-width { width: auto !important; } #u_content_image_1 .v-src-max-width { max-width: 31% !important; } #u_content_menu_1 .v-padding { padding: 5px 9px !important; } #u_content_heading_1 .v-container-padding-padding { padding: 40px 30px 20px !important; } #u_content_heading_1 .v-font-size { font-size: 28px !important; } #u_content_text_1 .v-container-padding-padding { padding: 0px 10px 10px !important; } #u_content_button_1 .v-container-padding-padding { padding: 10px 10px 40px !important; } #u_content_button_1 .v-size-width { width: 65% !important; } #u_content_social_1 .v-container-padding-padding { padding: 40px 10px 10px !important; } #u_content_text_2 .v-container-padding-padding { padding: 10px 10px 20px !important; } #u_content_image_3 .v-container-padding-padding { padding: 20px 10px 40px !important; } }\n" +
               "    </style>\n" +
               "  \n" +
               "  \n" +
               "\n" +
               "</head>\n" +
               "\n" +
               "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #ecf0f1;color: #000000\">\n" +
               "  <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #ecf0f1;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
               "  <tbody>\n" +
               "  <tr style=\"vertical-align: top\">\n" +
               "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
               "    \n" +
               "  \n" +
               "  \n" +
               "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
               "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
               "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
               "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
               "  <div style=\"background-color: #ffffff;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
               "<div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
               "  \n" +
               "<table id=\"u_content_image_1\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:25px 10px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
               "  <tr>\n" +
               "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
               "      \n" +
               "      <img align=\"center\" border=\"0\" src=\"https://i.ibb.co/B3MJxhh/logo-fernanpaaq.jpg\" alt=\"image\" title=\"image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 16%;max-width: 92.8px;\" width=\"92.8\" class=\"v-src-width v-src-max-width\"/>\n" +
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
               "</div>\n" +
               "  </div>\n" +
               "</div>\n" +
               "\n" +
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
               "     \n" +
               "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
               "  <div style=\"background-color: #ffffff;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
               "<div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 1px solid #000000;border-left: 1px solid #000000;border-right: 1px solid #000000;border-bottom: 1px solid #000000;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
               "  \n" +
               "<table id=\"u_content_menu_1\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "<div class=\"menu\" style=\"text-align:center\">\n" +
               "\n" +
               "  \n" +
               "  <span style=\"padding:5px 21px;display:inline-block;color:#000000;font-size:14px;\" class=\"v-padding v-font-size\">\n" +
               "    Página\n" +
               "  </span>\n" +
               "\n" +
               "    <span style=\"padding:5px 21px;display:inline-block;color:#000000;font-size:14px;\" class=\"v-padding v-font-size hide-mobile\">\n" +
               "      |\n" +
               "    </span>\n" +
               "\n" +
               "  \n" +
               "  <span style=\"padding:5px 21px;display:inline-block;color:#000000;font-size:14px;\" class=\"v-padding v-font-size\">\n" +
               "    App\n" +
               "  </span>\n" +
               "  \n" +
               "\n" +
               "    <span style=\"padding:5px 21px;display:inline-block;color:#000000;font-size:14px;\" class=\"v-padding v-font-size hide-mobile\">\n" +
               "      |\n" +
               "    </span>\n" +
               "\n" +
               "  \n" +
               "  <span style=\"padding:5px 21px;display:inline-block;color:#000000;font-size:14px;\" class=\"v-padding v-font-size\">\n" +
               "    Sobre nosotros\n" +
               "  </span>\n" +
               "  \n" +
               "\n" +
               "    <span style=\"padding:5px 21px;display:inline-block;color:#000000;font-size:14px;\" class=\"v-padding v-font-size hide-mobile\">\n" +
               "      |\n" +
               "    </span>\n" +
               "\n" +
               "  \n" +
               "  <span style=\"padding:5px 21px;display:inline-block;color:#000000;font-size:14px;\" class=\"v-padding v-font-size\">\n" +
               "    Contáctanos\n" +
               "  </span>\n" +
               "  \n" +
               "\n" +
               "</div>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               " </div>\n" +
               "  </div>\n" +
               "</div>\n" +
               "\n" +
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
               "    \n" +
               "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
               "  <div style=\"background-color: #ffffff;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
               "  <div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
               "  \n" +
               "<table id=\"u_content_heading_1\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:60px 150px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "\n" +
               "    <h1 class=\"v-font-size\" style=\"margin: 0px; line-height: 100%; text-align: center; word-wrap: break-word; font-size: 35px; font-weight: 400;\"><span><span style=\"line-height: 35px;\"></span><strong>Su envío ha sido actualizado</strong></span></h1>\n" +
               "  \n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
               "  <tr>\n" +
               "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
               "      \n" +
               "      <img align=\"center\" border=\"0\" src=\"https://i.ibb.co/xM2Z5QT/image-7.gif\" alt=\"image\" title=\"image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 600px;\" width=\"600\" class=\"v-src-width v-src-max-width\"/>\n" +
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
               "<table id=\"u_content_text_1\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 50px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "  <div class=\"v-font-size\" style=\"font-size: 14px; font-weight: 400; line-height: 160%; text-align: center; word-wrap: break-word;\">\n" +
               "    <p style=\"line-height: 160%;\"><span data-metadata=\"&lt;!--(figmeta)eyJmaWxlS2V5IjoiNDJNbkVhYll1SGtqbWw2RTBsMmdqbiIsInBhc3RlSUQiOjE4NTY4MjMyNTcsImRhdGFUeXBlIjoic2NlbmUifQo=(/figmeta)--&gt;\" style=\"line-height: 22.4px;\"></span>El envío " + numSeguimiento + " ha sido actualizado, ahora se encuentra " + estadoEnvio + ", su fecha proxima de entrega es para el dia " + dateExpect + ", y será entregado en " + direccionEntrega + ", " + localidad + ".</p>\n" +
               "<p style=\"line-height: 160%;\">¡" + nombre + " no te pierdas todas las novedades de tu envío!</p>\n" +
               "  </div>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "<table id=\"u_content_button_1\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 60px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "\n" +
               "<div align=\"center\">\n" +
               "\n" +
               "    <a href=\"\" target=\"_blank\" class=\"v-button v-size-width v-font-size\" style=\"box-sizing: border-box;display: inline-block;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #000000; background-color: #ffffff; border-radius: 4px;-webkit-border-radius: 4px; -moz-border-radius: 4px; width:32%; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;border-top-color: #916baf; border-top-style: solid; border-top-width: 1px; border-left-color: #916baf; border-left-style: solid; border-left-width: 1px; border-right-color: #916baf; border-right-style: solid; border-right-width: 1px; border-bottom-color: #916baf; border-bottom-style: solid; border-bottom-width: 1px;font-size: 14px;\">\n" +
               "      <span class=\"v-padding\" style=\"display:block;padding:10px 20px;line-height:120%;\"><strong><span style=\"line-height: 16.8px;\">Seguimiento de tu envío</span></strong></span>\n" +
               "    </a>\n" +
               "\n" +
               "</div>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "  </div>\n" +
               "  </div>\n" +
               "</div>\n" +
               "\n" +
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
               "\n" +
               "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
               "  <div style=\"background-color: #916baf;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
               "  <div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
               "  \n" +
               "<table id=\"u_content_social_1\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:60px 10px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "<div align=\"center\">\n" +
               "  <div style=\"display: table; max-width:167px;\">\n" +
               "\n" +
               "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 10px\">\n" +
               "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
               "        <a href=\"https://www.facebook.com/unlayer\" title=\"Facebook\" target=\"_blank\">\n" +
               "          <img src=\"https://i.ibb.co/Sm6NXT7/image-5.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
               "        </a>\n" +
               "      </td></tr>\n" +
               "    </tbody></table>\n" +
               "\n" +
               " \n" +
               "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 10px\">\n" +
               "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
               "        <a href=\"https://twitter.com/unlayerapp\" title=\"Twitter\" target=\"_blank\">\n" +
               "          <img src=\"https://i.ibb.co/bQm40sM/image-4.png\" alt=\"Twitter\" title=\"Twitter\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
               "        </a>\n" +
               "      </td></tr>\n" +
               "    </tbody></table>\n" +
               "\n" +
               "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 10px\">\n" +
               "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
               "        <a href=\"https://www.linkedin.com/company/unlayer/mycompany/\" title=\"LinkedIn\" target=\"_blank\">\n" +
               "          <img src=\"https://i.ibb.co/XXXWf3Q/image-3.png\" alt=\"LinkedIn\" title=\"LinkedIn\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
               "        </a>\n" +
               "      </td></tr>\n" +
               "    </tbody></table>\n" +
               "\n" +
               "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\n" +
               "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
               "        <a href=\"https://www.instagram.com\" title=\"Instagram\" target=\"_blank\">\n" +
               "          <img src=\"https://i.ibb.co/bvD90S2/image-6.png\" alt=\"Instagram\" title=\"Instagram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
               "        </a>\n" +
               "      </td></tr>\n" +
               "    </tbody></table>\n" +
               "\n" +
               "  </div>\n" +
               "</div>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "<table id=\"u_content_text_2\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 100px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
               "        \n" +
               "  <div class=\"v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 170%; text-align: center; word-wrap: break-word;\">\n" +
               "    <p style=\"line-height: 170%;\">Darse de baja   |   Políticas de privacidad   |   Web</p>\n" +
               "<p style=\"line-height: 170%;\"> </p>\n" +
               "<p style=\"line-height: 170%;\">No conteste correos si cree que se trata de una estafa.</p>\n" +
               "<p style=\"line-height: 170%;\">No nos hacemos responsables de las posibles estafas que se realizan en nuestro nombre.</p>\n" +
               "  </div>\n" +
               "\n" +
               "      </td>\n" +
               "    </tr>\n" +
               "  </tbody>\n" +
               "</table>\n" +
               "\n" +
               "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
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
               "<table id=\"u_content_image_3\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
               "  <tbody>\n" +
               "    <tr>\n" +
               "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
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
               "  </div>\n" +
               "  </div>\n" +
               "</div>\n" +
               "\n" +
               "    </div>\n" +
               "  </div>\n" +
               "  </div>\n" +
               "  \n" +
               "\n" +
               "\n" +
               "    </td>\n" +
               "  </tr>\n" +
               "  </tbody>\n" +
               "  </table>\n" +
               "\n" +
               "</body>\n" +
               "\n" +
               "</html>";
    }
}
