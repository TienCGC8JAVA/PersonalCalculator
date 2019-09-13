package controller;

import model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorPersonController {

  @RequestMapping("/")
  ModelAndView resultCalculator(@RequestParam(defaultValue = "0") float firstOperand,
                                @RequestParam(defaultValue = "0")float secondOperand,
                                @RequestParam(defaultValue = "*") char operator){
    ModelAndView modelAndView = new ModelAndView("calculator");
    modelAndView.addObject("firstOperand", firstOperand);
    modelAndView.addObject("secondOperand", secondOperand);
    modelAndView.addObject("operator", operator);
    try{
       float result = Calculator.calculate(firstOperand, secondOperand, operator);
      modelAndView.addObject("result", result);
    }catch (Exception e){
      modelAndView.addObject("result", e.getMessage());
    }
    return modelAndView;
  }
}
