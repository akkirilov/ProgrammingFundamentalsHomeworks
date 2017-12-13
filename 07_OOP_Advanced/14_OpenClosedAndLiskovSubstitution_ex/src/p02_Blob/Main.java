package p02_Blob;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

import p02_Blob.core.BlobController;
import p02_Blob.core.Engine;
import p02_Blob.io.Reader;
import p02_Blob.io.Writer;

public class Main {

	public static void main(String[] args) {
		
		BlobController blobController = new BlobController(new LinkedHashMap<>());
		Reader reader = new Reader(new BufferedReader(new InputStreamReader(System.in)));
		Writer writer = new Writer();
		
		Engine engine = new Engine(blobController, reader, writer);
		engine.run();
		
	}

}
