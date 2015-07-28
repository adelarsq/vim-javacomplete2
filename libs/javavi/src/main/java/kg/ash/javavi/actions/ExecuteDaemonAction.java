package kg.ash.javavi.actions;

import kg.ash.javavi.Daemon;
import kg.ash.javavi.Javavi;

public class ExecuteDaemonAction implements Action {

    @Override
    public String perform(String[] args) {
        Integer daemonPort = null;
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
            if (args[i].equals("-D")) {
                daemonPort = Integer.parseInt(args[i+1]);
                break;
            }
        }

        if (daemonPort == null) {
            return "Error: daemonPort is null";
        }

        if (Javavi.daemon == null) {
            Javavi.debug("Starting daemon mode");
            Javavi.daemon = new Daemon(daemonPort);
            Javavi.daemon.start();
        }

        return "";
    }
    
}