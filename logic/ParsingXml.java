package Ylab.Game_Lesson2.logic;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static Ylab.Game_Lesson2.Launcher.gamePlay;
import static Ylab.Game_Lesson2.body.Game.*;


public class ParsingXml {

    public void parse() throws ParserConfigurationException, FileNotFoundException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("Gameplay");
        Element player = document.createElement("PLayer");
        Element player2 = document.createElement("PLayer");
        Element game = document.createElement("Game");
        Element gameResult = document.createElement("GameResult");

        document.appendChild(root);
        root.appendChild(player);

        player.setAttribute("id", "1");
        player.setAttribute("name", firstPlayerName);
        player.setAttribute("symbol", "X");

        root.appendChild(player2);
        player2.setAttribute("id", "2");
        player2.setAttribute("name", secondPlayerName);
        player2.setAttribute("symbol", "O");

        root.appendChild(game);

        for (Move value : gamePlay.moves) {
            Element step = document.createElement("Step");
            step.setAttribute("num", Integer.toString(value.getNum()));
            step.setAttribute("playerId", Integer.toString(value.getPlayerId()));
            Text text = document.createTextNode(String.valueOf(value.getCoordinate()));
            step.appendChild(text);
            game.appendChild(step);
        }
            if(isWin1) {
                gameResult.setAttribute("playerId", "1");
                gameResult.setAttribute("name", firstPlayerName);
                gameResult.setAttribute("symbol", "X");
                root.appendChild(gameResult);
            }
            if (isWin2) {
                gameResult.setAttribute("playerId", "2");
                gameResult.setAttribute("name", secondPlayerName);
                gameResult.setAttribute("symbol", "O");
                root.appendChild(gameResult);
            }
            if (isDraw) {
                gameResult.setTextContent("Its Draw!");
                root.appendChild(gameResult);
            }
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("testInXML.xml")));
    }
}
