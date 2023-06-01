package com.nando.demochatGPT.commands;

import com.nando.demochatGPT.service.MealPlanService;
import com.nando.demochatGPT.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;


@ShellComponent
@RequiredArgsConstructor
public class ChatGPTCommands {

    private final MealPlanService mealPlanService;
    private final WorkoutService workoutService;

    @ShellMethod(key = "meal", value = "Get a meal plan of X amount of calories")
    public void mealPlan(@ShellOption(defaultValue = "2000") Integer calories) {
       mealPlanService.getMealPlan(calories);
    }
    @ShellMethod(key = "workout", value = "Get a quick workout for CHEST, BACK, LEGS or FULL BODY")
    public void workout(@ShellOption(arity = 4, defaultValue = "FULL BODY") List<String> type) {
        workoutService.getWorkout(type);
    }
}
