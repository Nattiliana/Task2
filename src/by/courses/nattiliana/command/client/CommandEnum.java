package by.courses.nattiliana.command.client;

import by.courses.nattiliana.command.*;
import by.courses.nattiliana.command.student.*;
import by.courses.nattiliana.command.tutor.*;

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
    },
    GO_TO_REGISTRATION {
        {
            this.command = new GoToRegistrationCommand();
        }
    },
    GO_BACK_TO_STUDENT {
        {
            this.command = new GoBackToStudentMainCommand();
        }
    },
    GO_BACK_TO_TUTOR {
        {
            this.command = new GoBackToTutorMainCommand();
        }
    },
    GO_TO_STUDENT_STAT {
        {
            this.command = new ShowStudentStatisticsCommand();
        }
    },
    GO_TO_TUTOR_STAT {
        {
            this.command = new ShowTutorStatisticsCommand();
        }
    },
    SHOW_QUIZ {
        {
            this.command = new ShowQuizCommand();
        }
    },
    SHOW_QUIZ_NEXT {
        {
            this.command = new ShowQuizNextCommand();
        }
    },
    CREATE_QUIZ {
        {
            this.command = new CreateQuizCommand();
        }
    },
    DELETE_QUIZ {
        {
            this.command = new DeleteQuizCommand();
        }
    },
    UPDATE {
        {
            this.command = new UpdateUserCommand();
        }
    },
    DELETE_USER {
        {
            this.command = new DeleteUserCommand();
        }
    },
    GO_TO_CREATE_QUIZ {
        {
            this.command = new GoToCreateQuizCommand();
        }
    },
    GO_TO_DELETE_QUIZ {
        {
            this.command = new GoToDeleteQuizCommand();
        }
    },
    GO_TO_DELETE_USER {
        {
            this.command = new GoToDeleteUserCommand();
        }
    },
    GO_TO_QUIZ {
        {
            this.command = new GoToQuizCommand();
        }
    },
    GO_BACK_TO_QUIZ {
        {
            this.command = new GoBackToQuizCommand();
        }
    },
    GO_TO_UPDATE {
        {
            this.command = new GoToUpdateUserCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}