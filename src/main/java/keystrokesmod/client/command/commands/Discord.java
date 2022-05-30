package keystrokesmod.client.command.commands;

import keystrokesmod.client.clickgui.raven.CommandLine;
import keystrokesmod.client.command.Command;
import keystrokesmod.client.main.Raven;
import keystrokesmod.client.utils.Utils;

public class Discord extends Command {
    public Discord() {
        super("discord", "Allows you to join the Raven B+ discord", 0, 3, new String[] {"copy", "open", "print"}, new String[] {"dc", "chat"});
    }

    @Override
    public void onCall(String[] args) {
        boolean opened = false;
        boolean copied = false;
        boolean showed = false;
        int argCurrent = 0;
        if(args == null) {
            CommandLine.print("§3Opening Discord...", 1);
            CommandLine.print("§a" + Raven.discord, 0);
            Utils.Client.openWebpage(Raven.discord);
            opened = true;
            return;
        }

        for (String argument : args) {
            if(argument.equalsIgnoreCase("copy")){
                if (!copied) {
                    Utils.Client.copyToClipboard(Raven.discord);
                    copied = true;
                    CommandLine.print("§aCopied to clipboard!", 1);
                }
            }
            else if(argument.equalsIgnoreCase("open")){
                if (!opened) {
                    Utils.Client.openWebpage(Raven.discord);
                    opened = true;
                    CommandLine.print("§aOpened invite link!", 1);
                }
            }
            else if(argument.equalsIgnoreCase("print")){
                if (!showed){
                    CommandLine.print("§a" + Raven.discord, 1);
                    showed = true;
                }
            } else {
                if (argCurrent != 0)
                    this.incorrectArgs();
            }
            argCurrent++;
        }
    }
}