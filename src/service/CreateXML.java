package service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.Const;


public class CreateXML {
  
  static List<String>  base_editions_array = Arrays.asList(Const.BASE_EDITIONS_ARRAY);
  static String[] sections = Const.SECTIONS;
  static List<Integer> days = Arrays.asList(Const.DAYS);

  public static void create(String startDate) throws Exception {
    
    days.stream().forEach(i -> {

      String date = startDate;
      Integer day = Integer.parseInt(date.substring(0, 2));

      date = day < 10 ? "0".concat(String.valueOf(day)).concat(date.substring(2)) : String.valueOf(day).concat(date.substring(2));
      String filename = "VST_20".concat(date.substring(4)).concat("_").concat(date.substring(2, 4)).concat("_").concat(date.substring(0, 2)).concat(".xml");

      try {
        writelXml(createDoc(date), filename);
      } catch (Exception e) {
        e.printStackTrace();
      }
      day += i == 1 ? 2 : 1;
    });

  }

  private static Document createDoc(String date) throws Exception {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);

    Document doc = factory.newDocumentBuilder().newDocument();
    Element root = doc.createElement("publication_plan");
    Element unit = doc.createElement("unit");
    Element publication = doc.createElement("publication");
    Element edition = doc.createElement("edition");
    Element pubdate = doc.createElement("pubdate");
    Element pages = doc.createElement("pages");

    doc.appendChild(root);
    unit.appendChild(doc.createTextNode("mm"));
    root.appendChild(unit);
    publication.appendChild(doc.createTextNode("ВЕСТИ"));
    root.appendChild(publication);
    edition.appendChild(doc.createTextNode("VST"));
    root.appendChild(edition);
    pubdate.appendChild(doc.createTextNode(date));
    root.appendChild(pubdate);
    pages.appendChild(doc.createTextNode("105"));
    root.appendChild(pages);


    base_editions_array.stream().forEach(edit -> {

      int n = 0;

      switch (edit) {
        case "BUF": n = 20; break;
        case "SEC": n = 25; break;
        default: n = 16; break;
      }

      for (int k = 1; k <= n; k++) {

        Element page = doc.createElement("page");
        root.appendChild(page);

        Element physical_page_number = doc.createElement("physical_page_number");
        Element logical_page_number = doc.createElement("logical_page_number");
        Element base_editions = doc.createElement("base_editions");
        Element height = doc.createElement("height");
        Element width = doc.createElement("width");
        Element colour = doc.createElement("colour");
        Element unique_id = doc.createElement("unique_id");
        Element modifier = doc.createElement("modifier");
        Element section = doc.createElement("section");
        Element dps = doc.createElement("dps");
        String id = "ВЕСТИ_".concat(edit).concat("_").concat(date).concat("_").concat(String.valueOf(k));

        physical_page_number.appendChild(doc.createTextNode(String.valueOf(k)));
        page.appendChild(physical_page_number);
        logical_page_number.appendChild(doc.createTextNode(String.valueOf(k)));
        page.appendChild(logical_page_number);
        base_editions.appendChild(doc.createTextNode(edit));
        page.appendChild(base_editions);
        height.appendChild(doc.createTextNode("375"));
        page.appendChild(height);
        width.appendChild(doc.createTextNode("259"));
        page.appendChild(width);
        colour.appendChild(doc.createTextNode("4"));
        page.appendChild(colour);
        unique_id.appendChild(doc.createTextNode(id));
        page.appendChild(unique_id);
        modifier.appendChild(doc.createTextNode("OO"));
        page.appendChild(modifier);
        section.appendChild(doc.createTextNode(edit == "BUF" ? edit : sections[k - 1]));
        page.appendChild(section);
        dps.appendChild(doc.createTextNode("0"));
        page.appendChild(dps);        
      }
    });

    return doc;
  }

  private static void writelXml(Document doc, String fileName) throws Exception {

    File file = new File(fileName);
    Transformer transformer;
    transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.transform(new DOMSource(doc), new StreamResult(file));
  }

}
