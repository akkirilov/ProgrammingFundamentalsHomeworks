package app;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.contracts.*;
import app.waste_disposal.core.*;
import app.waste_disposal.factories.*;
import app.waste_disposal.io.*;
import app.waste_disposal.models.strategies.*;
import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.annotations.*;

public class Main {
    public static void main(String[] args) {
    	
    	InputStreamReader is = new InputStreamReader(System.in);
    	InputReader reader = new Reader(is);
    	OutputWriter writer = new Writer();
    	List<ProcessingData> dataList = new ArrayList<>();
    	StrategyFactory strategyFactory = new StrategyFactoryImpl();
    	WasteFactory wasteFactory = new WasteFactoryImpl();
    	StrategyHolder strategyHolder = new DefaultStrategyHolder();
    	GarbageDisposalStrategy recyclableGarbageStrategy = new RecyclableGarbageStrategy();
    	GarbageDisposalStrategy burnableGarbageStrategy = new BurnableGarbageStrategy();
    	GarbageDisposalStrategy storableGarbageStrategy = new StorableGarbageStrategy();
    	strategyHolder.addStrategy(Recyclable.class, recyclableGarbageStrategy);
    	strategyHolder.addStrategy(Burnable.class, burnableGarbageStrategy);
    	strategyHolder.addStrategy(Storable.class, storableGarbageStrategy);
    	GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(strategyHolder);
    	Manager manager = new WasteManager(dataList, strategyFactory, wasteFactory, garbageProcessor);
    	Engine engine = new WasteEngine(reader, writer, manager);
    	engine.run();
    	
    }
    
}
