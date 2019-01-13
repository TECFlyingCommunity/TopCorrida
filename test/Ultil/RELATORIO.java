/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultil;

import MainApp.MainApp;
import Model.Chegada;
import com.qoppa.pdfWriter.PDFDocument;
import java.awt.print.PageFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro_ERMarinho
 */
  public  class RELATORIO {

    
      public static void RELATORIO(MainApp mainapp) {
          
          
          
          System.out.println("RELATORIO");
          
          String registros="";
          
          int cont=0;
          for( Chegada rg: mainapp.getPersonData2()){
              cont++;                      
              registros+="<tr>" +
"                <td style=\"text-align:left;width:1.005cm; \" class=\"Table1_A2\">" +
"                    <p class=\"P7\">"+cont+"</p>" +
"                </td>" +
"                <td style=\"text-align:left;width:1.588cm; \" class=\"Table1_B2\">" +
"                    <p class=\"P7\">"+rg.getRegistro()+"</p>" +
"                </td>" +
"                <td style=\"text-align:left;width:8.705cm; \" class=\"Table1_C2\">" +
"                    <p class=\"P7\">"+rg.getNome()+" "+rg.getSegundoNome()+"</p>" +
"                </td>" +
"                <td style=\"text-align:left;width:3.353cm; \" class=\"Table1_D2\">" +
"                    <p class=\"P8\">"+rg.getChegada()+"</p>" +
"                </td>" +
"            </tr>";
          }
          
              
              
        String site = " " +
"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1 plus MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/xhtml-math11-f.dtd\">"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\"><!--This file was converted to xhtml by LibreOffice - see http://cgit.freedesktop.org/libreoffice/core/tree/filter/source/xslt for the code.--><head profile=\"http://dublincore.org/documents/dcmi-terms/\"><meta http-equiv=\"Content-Type\" content=\"application/xhtml+xml; charset=utf-8\"/><title xml:lang=\"en-US\">- no title specified</title><meta name=\"DCTERMS.title\" content=\"\" xml:lang=\"en-US\"/><meta name=\"DCTERMS.language\" content=\"en-US\" scheme=\"DCTERMS.RFC4646\"/><meta name=\"DCTERMS.source\" content=\"http://xml.openoffice.org/odf2xhtml\"/><meta name=\"DCTERMS.issued\" content=\"2018-09-05T18:51:11.620321464\" scheme=\"DCTERMS.W3CDTF\"/><meta name=\"DCTERMS.modified\" content=\"2018-09-05T19:00:11.105295376\" scheme=\"DCTERMS.W3CDTF\"/><meta name=\"DCTERMS.provenance\" content=\"\" xml:lang=\"en-US\"/><meta name=\"DCTERMS.subject\" content=\",\" xml:lang=\"en-US\"/><link rel=\"schema.DC\" href=\"http://purl.org/dc/elements/1.1/\" hreflang=\"en\"/><link rel=\"schema.DCTERMS\" href=\"http://purl.org/dc/terms/\" hreflang=\"en\"/><link rel=\"schema.DCTYPE\" href=\"http://purl.org/dc/dcmitype/\" hreflang=\"en\"/><link rel=\"schema.DCAM\" href=\"http://purl.org/dc/dcam/\" hreflang=\"en\"/><style type=\"text/css\">" +
"            @page {  }" +
"            table { border-collapse:collapse; border-spacing:0; empty-cells:show }" +
"            td, th { vertical-align:top; font-size:12pt;}" +
"            h1, h2, h3, h4, h5, h6 { clear:both;}" +
"            ol, ul { margin:0; padding:0;}" +
"            li { list-style: none; margin:0; padding:0;}" +
"            /* \"li span.odfLiEnd\" - IE 7 issue*/" +
"            li span. { clear: both; line-height:0; width:0; height:0; margin:0; padding:0; }" +
"            span.footnodeNumber { padding-right:1em; }" +
"            span.annotation_style_by_filter { font-size:95%; font-family:Arial; background-color:#fff000;  margin:0; border:0; padding:0;  }" +
"            span.heading_numbering { margin-right: 0.8rem; }* { margin:0;}" +
"            .P1 { font-size:18pt; text-align:center ! important; font-family:Calibri; writing-mode:lr-tb; }" +
"            .P10 { font-size:10.5pt; text-align:justify ! important; font-family:Calibri; writing-mode:lr-tb; }" +
"            .P11 { font-size:11pt; text-align:center ! important; font-family:Calibri; writing-mode:lr-tb; }" +
"            .P2 { font-size:10.5pt; text-align:left ! important; font-family:Calibri; writing-mode:lr-tb; }" +
"            .P6 { font-size:10.5pt; text-align:center ! important; font-family:Calibri; writing-mode:lr-tb; }" +
"            .P7 { font-size:10.5pt; text-align:justify ! important; font-family:Calibri; writing-mode:lr-tb; }" +
"            .P8 { font-size:10.5pt; text-align:center ! important; font-family:Calibri; writing-mode:lr-tb; }" +
"            .P9 { font-size:12.5pt; text-align:justify ! important; font-family:Calibri; writing-mode:lr-tb; }" +
"            .Table1 { width:14.651cm; float:none; writing-mode:lr-tb; }" +
"            .Table1_A1 { padding:0.097cm; border-left-width:thin; border-left-style:solid; border-left-color:#000000; border-right-style:none; border-top-width:thin; border-top-style:solid; border-top-color:#000000; border-bottom-width:thin; border-bottom-style:solid; border-bottom-color:#000000; }" +
"            .Table1_A2 { padding:0.097cm; border-left-width:thin; border-left-style:solid; border-left-color:#000000; border-right-style:none; border-top-style:none; border-bottom-width:thin; border-bottom-style:solid; border-bottom-color:#000000; }" +
"            .Table1_B2 { padding:0.097cm; border-left-width:thin; border-left-style:solid; border-left-color:#000000; border-right-style:none; border-top-style:none; border-bottom-width:thin; border-bottom-style:solid; border-bottom-color:#000000; }" +
"            .Table1_C1 { vertical-align:bottom; padding:0.097cm; border-left-width:thin; border-left-style:solid; border-left-color:#000000; border-right-style:none; border-top-width:thin; border-top-style:solid; border-top-color:#000000; border-bottom-width:thin; border-bottom-style:solid; border-bottom-color:#000000; }" +
"            .Table1_C2 { vertical-align:bottom; padding:0.097cm; border-left-width:thin; border-left-style:solid; border-left-color:#000000; border-right-style:none; border-top-style:none; border-bottom-width:thin; border-bottom-style:solid; border-bottom-color:#000000; }" +
"            .Table1_D1 { padding:0.097cm; border-width:thin; border-style:solid; border-color:#000000; }" +
"            .Table1_D2 { padding:0.097cm; border-left-width:thin; border-left-style:solid; border-left-color:#000000; border-right-width:thin; border-right-style:solid; border-right-color:#000000; border-top-style:none; border-bottom-width:thin; border-bottom-style:solid; border-bottom-color:#000000; }" +
"            .Table1_A { width:1.005cm; }" +
"            .Table1_B { width:1.588cm; }" +
"            .Table1_C { width:8.705cm; }" +
"            .Table1_D { width:3.353cm; }" +
"            .T1 { font-size:18pt; }" +
"            .T2 { font-size:14pt; }" +
"            /* ODF styles with no properties representable as CSS */" +
"            /*{ }*/" +
"        </style>" +
"    </head>" +
"    <body dir=\"ltr\" style=\"max-width:21.001cm;margin-top:2.54cm; margin-bottom:2.54cm; margin-left:3.175cm; margin-right:3.175cm; \">" +
"        <p class=\"P6\"><span class=\"T1\">Lista de Chegada</span></p>" +
"        <p class=\"P1\"> </p>" +
"        <p class=\"P2\"><span class=\"T2\">Categoria: @Categoria</span></p>" +
"        <p class=\"P2\"><span class=\"T2\"/></p>" +
"        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"Table1\">" +
"            <colgroup>" +
"                <col width=\"44\"/>" +
"                <col width=\"69\"/>" +
"                <col width=\"380\"/>" +
"                <col width=\"147\"/>" +
"            </colgroup>" +
"            <tr>" +
"                <td style=\"text-align:left;width:1.005cm; \" class=\"Table1_A1\">" +
"                    <p class=\"P9\">P.</p>" +
"                </td>" +
"                <td style=\"text-align:left;width:1.588cm; \" class=\"Table1_A1\">" +
"                    <p class=\"P10\">RG</p>" +
"                </td><td style=\"text-align:left;width:8.705cm; \" class=\"Table1_C1\">" +
"                    <p class=\"P9\">NOME</p>" +
"                </td>" +
"                <td style=\"text-align:left;width:3.353cm; \" class=\"Table1_D1\">" +
"                    <p class=\"P11\">TEMPO</p>" +
"                </td>" +
"            </tr>" +
"<!--        ---------------------------------------------------------" +
"            -                                                       -" +
"            -                                                       -" +
"            -                   area para registros                 -" +
"            -                                                       -" +
"            -                                                       -" +
"            --------------------------------------------------------- -->" +
"            "+registros+" " +
"        </table>" +
"        <p class=\"P2\"><span class=\"T2\"/></p>" +
"    </body>" +
"</html>";

        
        FileWriter arquivo;
          System.out.println("salvando");
        
          
          try {
            arquivo = new FileWriter(new File("Arquivo.html"));
            arquivo.write(site);
            arquivo.close();
       
        Locale ptBr = new Locale("pt", "BR");
        File f1 = new File("Arquivo.html");
            Date dt=new Date();
            PDFDocument pdfDoc = PDFDocument.loadHTML(f1.toURI().toURL(), new PageFormat(), false);
            pdfDoc.saveDocument("teste.pdf");
            System.err.println("salvo");
        } catch (Exception ex) {
            System.err.println("não foi salvo");
            ex.printStackTrace();
        }

    }

   
}
