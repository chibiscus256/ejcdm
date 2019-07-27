package homework11;

import homework11.ATM.*;

public class ATMFactory {

    public static ATM createATM(ATMs atm) {
        switch (atm) {
            case Uni:
                return new UniATM();

            case Vtb:
                return new VtbATM();

            case Sber:
                return new SberATM();
        }

        throw new IllegalArgumentException("No such ATM");
    }
}