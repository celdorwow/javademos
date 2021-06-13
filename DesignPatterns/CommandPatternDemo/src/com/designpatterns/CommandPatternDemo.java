package com.designpatterns;

import java.util.Arrays;
import java.util.List;

public class CommandPatternDemo {

    public static void main(String[] args) {
        Lamp philipsLamp = new PhilipsLamp();

	    // Setup invoker
        Command pressOn = new LampOn(philipsLamp);
	    Command pressOff = new LampOff(philipsLamp);
	    Command brightUp = new LevelUp(philipsLamp);
	    Command dimDown = new LevelDown(philipsLamp);

	    // run invoker
        Command[] commands1 = new Command[]{
            pressOn, brightUp, brightUp, brightUp, dimDown, pressOff, pressOn,
        };
        executeSequenceAndPrint(commands1, philipsLamp);

        // run invoker in sequence
        Command[] commands2 = new Command[]{
            pressOn, brightUp, brightUp, dimDown, dimDown, dimDown,
        };
        executeSequence(commands2);
        System.out.println();
        System.out.println(philipsLamp);
    }

    public static void executeSequence(List<Command> sq) {
        sq.forEach(Command::execute);
    }
    public static void executeSequence(Command[] sq) {
        executeSequence(Arrays.asList(sq));
    }

    public static void executeSequenceAndPrint(List<Command> sq, Lamp lamp) {
        sq.forEach(e -> {
            e.execute();
            System.out.println(lamp);
        });
    }
    public static void executeSequenceAndPrint(Command[] sq, Lamp lamp) {
        executeSequenceAndPrint(Arrays.asList(sq), lamp);
    }
}
