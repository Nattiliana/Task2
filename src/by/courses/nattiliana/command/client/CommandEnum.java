package by.courses.nattiliana.command.client;

import by.courses.nattiliana.command.*;

public enum CommandEnum {

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },

    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    RETURN {
        {
            this.command = new EmptyCommand();
        }
    },
    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}