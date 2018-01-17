package app;

import app.contracts.ActionFactory;
import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;
import app.contracts.TargetableFactory;
import app.contracts.Writer;
import app.core.BattlefieldImplementation;
import app.core.EngineImpl;
import app.factory.ActionFactoryImpl;
import app.factory.TargetableFactoryImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	Reader reader = new ConsoleReader();
    	Writer writer = new ConsoleWriter();
    	TargetableFactory targetableFactory = new TargetableFactoryImpl();
    	ActionFactory actionFactory = new ActionFactoryImpl();
    	Battlefield battleField = new BattlefieldImplementation(writer, targetableFactory, actionFactory);
    	Engine engine = new EngineImpl(reader, battleField);
    	engine.run();
//        ConsoleReader reader = new ConsoleReader();
//        ConsoleWriter writer = new ConsoleWriter();
//        Battlefield battleField = new BattlefieldImplementation(writer);
//
//        String line = reader.readLine();
//        while (!line.equals("Peace")){
//            String[] lineTokens = line.split("\\s+");
//
//            switch (lineTokens[0].toLowerCase()){
//                case "createparticipant" :
//                    battleField.createParticipant(lineTokens[1], lineTokens[2]);
//                    break;
//                case "createaction" :
//                    battleField.createAction(lineTokens[1],
//                            Arrays.copyOf(Arrays.stream(lineTokens).skip(2).toArray(),
//                                    Arrays.stream(lineTokens).skip(2).toArray().length,
//                                    String[].class));
//                    break;
//                default:
//                    System.out.println("Invalid command");
//                    break;
//            }
//
//            line = reader.readLine();
//        }

    }
}
