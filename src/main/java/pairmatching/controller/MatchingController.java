package pairmatching.controller;

import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

    private final MatchingService matchingService = new MatchingService();

    public void run() {
        OutputView.start();
        String menu = InputView.menu();

        OutputView.step();
        OutputView.inputStep();
        do {
            switch (menu) {
                case "1":
                    matchingService.matchPairs(InputView.step());
                    String result = matchingService.findPairs(InputView.step());
                    OutputView.result(result);
                    break;
                case "2":
                    String found = matchingService.findPairs(InputView.step());
                    OutputView.result(found);
                    break;
                case "3":
                    matchingService.clear();
                    OutputView.clear();
                    break;
            }
        } while (menu.equals("Q"));
    }
}
