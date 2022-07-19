package com.example.myapplication4mt19cs073lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    TextView xml_contents, json_contents;
    Button parse_json, parse_xml;

    String cname, latit, longig, temp, humid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xml_contents = (TextView) findViewById(R.id.XML_contents);
        json_contents = (TextView) findViewById(R.id.JSON_contents);
        parse_xml = (Button) findViewById(R.id.Parse_XML);
        parse_json = (Button) findViewById(R.id.Parse_JSON);

        parse_xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream is = getAssets().open("city.xml");
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(is);
                    NodeList nList = doc.getElementsByTagName("cities");
                    System.out.println(nList.item(0).getNodeName());

                    for (int i = 0; i < nList.getLength(); i++) {
                        Element element2 = (Element) nList.item(i);
                        cname = element2.getElementsByTagName("cname").item(0).getFirstChild().getNodeValue();
                        latit = element2.getElementsByTagName("latitude").item(0).getFirstChild().getNodeValue();
                        longig = element2.getElementsByTagName("longitude").item(0).getFirstChild().getNodeValue();
                        temp = element2.getElementsByTagName("Temp").item(0).getFirstChild().getNodeValue();
                        System.out.println(cname);
                        System.out.println(temp);
                        xml_contents.setText(xml_contents.getText() + "\nCity \t\t: \t\t" + cname +  "\nLat \t\t: \t\t" + latit + "\nLong \t: \t\t" + longig + "\nTemp : \t" + temp);
                    }
                }

                catch (IOException | ParserConfigurationException | SAXException e) {
                    e.printStackTrace();
                }
            }
        });

        parse_json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream is1 = getAssets().open("test.json");
                    byte[] buffer = new byte[is1.available()];
                    is1.read(buffer);
                    String jsonString = new String(buffer);
                    JSONObject reader = new JSONObject(jsonString);
                    JSONObject user1 = reader.getJSONObject("User1");
                    String name = user1.getString("name");
                    System.out.println(name);
                    String age = user1.getString("age");
                    String car = user1.getString("car");
                    json_contents.setText(json_contents.getText() + "\nName : \t" + name + "\nAge \t\t : \t" + age + "\nCar \t\t : \t" + car);
                }

                catch(JSONException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}