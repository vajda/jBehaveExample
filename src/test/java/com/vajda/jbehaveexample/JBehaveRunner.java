package com.vajda.jbehaveexample;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import com.vajda.jbehaveexample.steps.ExampleSteps;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

/**
 * @author Vladimir Vajda
 */
@RunWith(JUnitReportingRunner.class)
public class JBehaveRunner extends JUnitStories {
    
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(new MostUsefulConfiguration(), getStepsClasses());
    }

    @Override
    protected List<String> storyPaths() {
        String codeLocation = CodeLocations.codeLocationFromClass(this.getClass()).getFile();
        return new StoryFinder().findPaths(codeLocation, Arrays.asList("**/*.story"), Arrays.asList(""));
    }
    
    private Object[] getStepsClasses() {
        return new Object[] {
          new ExampleSteps()                   
        };
    }
}
