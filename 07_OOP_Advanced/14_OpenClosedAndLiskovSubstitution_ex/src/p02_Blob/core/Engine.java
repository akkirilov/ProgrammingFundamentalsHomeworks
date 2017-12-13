package p02_Blob.core;

import p02_Blob.io.Reader;
import p02_Blob.io.Writer;

public class Engine {

	private boolean printCommandDetails;
	private boolean isFirstCommand;
	private BlobController blobController;
	private Reader reader;
	private Writer writer;
	
	public Engine(BlobController blobController, Reader reader, Writer writer) {
		this.blobController = blobController;
		this.reader = reader;
		this.writer = writer;
		this.printCommandDetails = false;
		this.isFirstCommand = true;
	}

	public void run() {
		
		String res = "";
		
		while(true) {
			String[] commands = this.reader.readCommands("\\s+");
			if (commands[0].equalsIgnoreCase("drop")) {
				break;
			} else if (this.isFirstCommand && commands[0].equalsIgnoreCase("report-events")) {
				this.printCommandDetails = true;
				continue;
			}
			
			this.isFirstCommand = false;
			switch (commands[0]) {
			case "create":
				res = this.blobController.create(commands[1], Integer.parseInt(commands[2]), Integer.parseInt(commands[3]), commands[4], commands[5]);
				break;
			case "pass":
				res = this.blobController.pass();
				break;
			case "status":
				res = this.blobController.status();
				this.writer.write(res);
				break;
			case "attack":
				res = this.blobController.attack(commands[1], commands[2]);
				if (printCommandDetails) {
					this.printAttackDetails(res);
				}
				break;
			default:
				break;
			}
		}
		
	}

	private void printAttackDetails(String res) {
		if (res != null) {
			this.writer.writeLine(res);
		}
		
	}
	
}
