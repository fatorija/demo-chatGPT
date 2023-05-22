package com.nando.demochatGPT.commands;

import com.nando.demochatGPT.service.MealPlanService;
import com.nando.demochatGPT.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;
import java.util.stream.Collectors;


@ShellComponent
@Log4j2
@RequiredArgsConstructor
public class ChatGPTCommands {

    private final MealPlanService mealPlanService;
    private final WorkoutService workoutService;

    @ShellMethod(key = "meal", value = "Get a meal plan of X amount of calories")
    public void mealPlan(@ShellOption(defaultValue = "2000") Integer calories) {
//       log.debug("getting a meal plan of X calories {}", calories);
       mealPlanService.getMealPlan(calories);
    }
    @ShellMethod(key = "workout", value = "Get a quick workout for CHEST, BACK, LEGS or FULL BODY")
    public void workout(@ShellOption(arity = 4, defaultValue = "FULL BODY") List<String> type) {
//        log.debug("Generating workout for {}", () -> type
//                .stream()
//                .filter(t -> t.equals("FULL BODY"))
//                .collect(Collectors.joining(",")));
        workoutService.getWorkout(type);
    }
}
