package be.realdolmen.zoo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ZooApplicationTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();

    @InjectMocks
    private ZooApplication zooApplication ;

    @Test
    public void verifyShownCommands() throws InterruptedException {
        systemInMock.provideLines("0");
        Commander.Commands chosenCommand = zooApplication.chooseCommand();
        // will create a string with a lineSeparator depending on the system OS lineSeparator settings (CRLF or LF)
        // LF = unix and macOs (\n)
        // CR = classic macOs (\r)
        // CRLF = windows (\n\r)
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add("Available commands:")
                .add("\t0. Show animals")
                .add("\t1. Add new animal")
                .add("\t2. Remove animal")
                .add("\t3. Add ticket price")
                .add("\t4. Feed animals")
                .add("\t5. Show visitors ")
                .add("Choose a command: ");
        assertEquals(stringJoiner.toString(), systemOutRule.getLog());
    }

    @Test
    public void verifyReturnShowAnimalCommand() throws InterruptedException {
        systemInMock.provideLines("0");
        Commander.Commands chosenCommand = zooApplication.chooseCommand();
        assertEquals(Commander.Commands.SHOW_ANIMAL, chosenCommand);
    }

    @Test
    public void verifyReturnAddAnimalCommand() throws InterruptedException {
        systemInMock.provideLines("1");
        Commander.Commands chosenCommand = zooApplication.chooseCommand();
        assertEquals(Commander.Commands.ADD_ANIMAL, chosenCommand);
    }

    @Test
    public void verifyReturnRemoveAnimalCommand() throws InterruptedException {
        systemInMock.provideLines("2");
        Commander.Commands chosenCommand = zooApplication.chooseCommand();
        assertEquals(Commander.Commands.REMOVE_ANIMAL, chosenCommand);
    }

    @Test
    public void verifyReturnFeedAnimalCommand() throws InterruptedException {
        systemInMock.provideLines("4");
        Commander.Commands chosenCommand = zooApplication.chooseCommand();
        assertEquals(Commander.Commands.FEED_ANIMAL, chosenCommand);
    }

} 
