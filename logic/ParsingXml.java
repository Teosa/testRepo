package Ylab.Game_Lesson2.logic;

import Ylab.Game_Lesson2.logic.XmlReader.Move;
import Ylab.Game_Lesson2.logic.XmlReader.Player;
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

import static Ylab.Game_Lesson2.LauncherNew.gamePlay;
import static Ylab.Game_Lesson2.body.Game.*;


public class ParsingXml {

    public void parse(Player playerOne, Player playerTwo) throws ParserConfigurationException, FileNotFoundException, TransformerException {
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
        root.appendChild(player2);

        player.setAttribute("id", playerOne.getId());
        player.setAttribute("name", playerOne.getName());
        player.setAttribute("symbol", playerOne.getSymbol());


        player2.setAttribute("id", playerTwo.getId());
        player2.setAttribute("name", playerTwo.getName());
        player2.setAttribute("symbol", playerTwo.getSymbol());

        root.appendChild(game);

        for (Move value : gamePlay.moves) {
            Element step = document.createElement("Step");
            step.setAttribute("num", Integer.toString(value.getNum()));
            step.setAttribute("playerId", Integer.toString(value.getPlayerId()));
            Text text = document.createTextNode(Integer.toString(value.getCoordinate()));
            step.appendChild(text);
            game.appendChild(step);
        }
            if(playerOne.isWinner()) {
                gameResult.setAttribute("playerId", playerOne.getId());
                gameResult.setAttribute("WINNER", playerOne.getName());
                gameResult.setAttribute("symbol", playerOne.getSymbol());
                root.appendChild(gameResult);
            }
            else if (playerTwo.isWinner()) {
                gameResult.setAttribute("playerId", playerTwo.getId());
                gameResult.setAttribute("WINNER", playerTwo.getName());
                gameResult.setAttribute("symbol", playerTwo.getSymbol());
                root.appendChild(gameResult);
            }
            else {
                gameResult.setTextContent("Its Draw!");
                root.appendChild(gameResult);
            }
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("testInXML.xml")));
    }
}
