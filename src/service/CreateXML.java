package service;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML {
  
  static String[] base_editions_array = {"BUF", "SEC", "DNE", "ODS", "KHA", "UKR", "KIE"};
  static String[] sections = {"FST", "STR", "STR", "STR", "STR", "STR", "STR", "STR", "STR", "STR", "STR", "STR", "STR", "STR", "STR", "LST", "OBU", "RBT", "SEM", "SIT", "TCH", "TOP", "ZDR", "STR", "STR"};

  public static void create(String startDate) throws Exception {
    
    String date = startDate;
    int day = Integer.parseInt(date.substring(0, 2));
    int[] days = {1, 3, 4};

    for (int i : days) {
      date = day < 10 ? "0".concat(String.valueOf(day)).concat(date.substring(2)) : String.valueOf(day).concat(date.substring(2));
      String filename = "VST_20".concat(date.substring(4)).concat("_").concat(date.substring(2, 4)).concat("_").concat(date.substring(0, 2)).concat(".xml");
      writelXml(createDoc(date), filename);
      day += i == 1 ? 2 : 1;
    }

  }

  private static Document createDoc(String date) throws Exception {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);

    Document doc = factory.newDocumentBuilder().newDocument();

    Element root = doc.createElement("publication_plan");
    doc.appendChild(root);

    Element unit = doc.createElement("unit");
    unit.appendChild(doc.createTextNode("mm"));
    root.appendChild(unit);

    Element publication = doc.createElement("publication");
    publication.appendChild(doc.createTextNode("ВЕСТИ"));
    root.appendChild(publication);

    Element edition = doc.createElement("edition");
    edition.appendChild(doc.createTextNode("VST"));
    root.appendChild(edition);

    Element pubdate = doc.createElement("pubdate");
    pubdate.appendChild(doc.createTextNode(date));
    root.appendChild(pubdate);

    Element pages = doc.createElement("pages");
    pages.appendChild(doc.createTextNode("105"));
    root.appendChild(pages);

    int n = 0;

    for (String edit : base_editions_array) {

      switch (edit) {
        case "BUF":
          n = 20;
          break;
        case "SEC":
          n = 25;
          break;
        default:
          n = 16;
          break;
      }

      for (int k = 1; k <= n; k++) {

        Element page = doc.createElement("page");
        root.appendChild(page);

        Element physical_page_number = doc.createElement("physical_page_number");
        physical_page_number.appendChild(doc.createTextNode(String.valueOf(k)));
        page.appendChild(physical_page_number);

        Element logical_page_number = doc.createElement("logical_page_number");
        logical_page_number.appendChild(doc.createTextNode(String.valueOf(k)));
        page.appendChild(logical_page_number);

        Element base_editions = doc.createElement("base_editions");
        base_editions.appendChild(doc.createTextNode(edit));
        page.appendChild(base_editions);

        Element height = doc.createElement("height");
        height.appendChild(doc.createTextNode("375"));
        page.appendChild(height);

        Element width = doc.createElement("width");
        width.appendChild(doc.createTextNode("259"));
        page.appendChild(width);

        Element colour = doc.createElement("colour");
        colour.appendChild(doc.createTextNode("4"));
        page.appendChild(colour);

        String id = "ВЕСТИ_".concat(edit).concat("_").concat(date).concat("_").concat(String.valueOf(k));
        Element unique_id = doc.createElement("unique_id");
        unique_id.appendChild(doc.createTextNode(id));
        page.appendChild(unique_id);

        Element modifier = doc.createElement("modifier");
        modifier.appendChild(doc.createTextNode("00"));
        page.appendChild(modifier);

        Element section = doc.createElement("section");
        section.appendChild(doc.createTextNode(edit == "BUF" ? edit : sections[k - 1]));
        page.appendChild(section);

        Element dps = doc.createElement("dps");
        dps.appendChild(doc.createTextNode("0"));
        page.appendChild(dps);        
      }
    }

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
