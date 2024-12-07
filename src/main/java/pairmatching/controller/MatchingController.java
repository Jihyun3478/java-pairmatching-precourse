package pairmatching.controller;

import pairmatching.dto.MenuRequest;
import pairmatching.dto.PairResponse;
import pairmatching.dto.StepRequest;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

    private final MatchingService matchingService = new MatchingService();

    public void run() {
        MenuRequest menu;
        do {
            OutputView.start();
            menu = InputView.menu();
            matchingService.setUp();
            OutputView.step();
            OutputView.inputStep();

            switch (menu.getMenu()) {
                case "1":
                    StepRequest step = InputView.step();
                    matchingService.matchPairs(step);
                    PairResponse result = matchingService.findPairs(step);
                    OutputView.result(result);
                    break;
                case "2":
                    PairResponse found = matchingService.findPairs(InputView.step());
                    OutputView.result(found);
                    break;
                case "3":
                    matchingService.clear();
                    OutputView.clear();
                    break;
            }
        } while (!menu.getMenu().equals("Q"));
    }
}
