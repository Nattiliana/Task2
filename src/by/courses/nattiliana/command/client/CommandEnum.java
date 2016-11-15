package by.courses.nattiliana.command.client;

import by.courses.nattiliana.command.*;
import by.courses.nattiliana.command.student.GoBackToStudentMainCommand;
import by.courses.nattiliana.command.student.ShowQuizCommand;
import by.courses.nattiliana.command.student.ShowStudentStatisticsCommand;
import by.courses.nattiliana.command.tutor.CreateQuizCommand;
import by.courses.nattiliana.command.tutor.DeleteQuizCommand;
import by.courses.nattiliana.command.tutor.GoBackToTutorMainCommand;
import by.courses.nattiliana.command.tutor.ShowTutorStatisticsCommand;

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
    CREATE_QUIZ {
        {
            this.command = new CreateQuizCommand();
        }
    },
    DELETE_QUIZ {
        {
            this.command = new DeleteQuizCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}