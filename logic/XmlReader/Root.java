package Ylab.Game_Lesson2.logic.XmlReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Root {

	public static final List<Player> players = new ArrayList<>();

	public static final List<Move> moves = new ArrayList<>();

	public static Move getMoveByIdAndName(Integer playerId, Integer moveCounter ) {
		return moves.stream().filter(move ->
			playerId.equals(move.getPlayerId()) && moveCounter.equals(move.num))
				.findFirst()
				.orElse(null);
	}

	public static void read(final String filename) throws ParserConfigurationException, IOException, SAXException {
		File file = new File(filename);
		Document doc;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		doc = dbf.newDocumentBuilder().parse(file);

		NodeList playerElements = doc.getDocumentElement().getElementsByTagName("PLayer");
		for (int i = 0; i < playerElements.getLength(); i++) {
			Node player = playerElements.item(i);
			NamedNodeMap attributes = player.getAttributes();
			players.add(new Player(attributes.getNamedItem("id").getNodeValue(),
					attributes.getNamedItem("name").getNodeValue(),
					attributes.getNamedItem("symbol").getNodeValue()
			));
		}
		for (Player value : players) {
			System.out.printf("Информации о игроках: ID игрока - %s, имя игрока - %s, символ игрока - %s %n",
					value.getId(), value.getName(), value.getSymbol()
			);
		}

		NodeList movesElements = doc.getDocumentElement().getElementsByTagName("Step");

		for (int i = 0; i < movesElements.getLength(); i++) {
			Node move = movesElements.item(i);
			NamedNodeMap attributes = move.getAttributes();

			moves.add(new Move(Integer.parseInt(attributes.getNamedItem("playerId").getNodeValue()),
					Integer.parseInt(move.getTextContent()),
					Integer.parseInt(attributes.getNamedItem("num").getNodeValue())
			));
		}
		for (Move value : moves) {
			System.out.printf("Информации о ходах: номер хода - %s, ID игрока - %s, координата хода - %s %n",
					value.getNum(), value.getPlayerId(), value.getCoordinate()
			);
		}


	}

}
