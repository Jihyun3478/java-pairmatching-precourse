package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.dto.MenuRequest;
import pairmatching.dto.StepRequest;

public class InputView {
    public static MenuRequest menu() {
        return MenuRequest.from(Console.readLine());
    }

    public static StepRequest step() {
        return StepRequest.of(Console.readLine());
    }
}
