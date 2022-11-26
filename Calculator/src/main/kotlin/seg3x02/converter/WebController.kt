package seg3x02.converter

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class WebController {
    @ModelAttribute
    fun addAttributes(model: Model) {
        model.addAttribute("error", "")
        model.addAttribute("number1", "")
        model.addAttribute("number2", "")
    }

    @RequestMapping("/")
    fun home(): String {
        return "home"
    }

    @GetMapping(value = ["/calculate"])
    fun doConvert(
        @RequestParam(value = "number1", required = false) number1: String,
        @RequestParam(value = "number2", required = false) number2: String,
        @RequestParam(value = "operation", required = false) operation: String,
        model: Model
    ): String {
        var number1Val: Double
        var number2Val: Double
        when (operation) {
            "add" ->
                try {
                    number1Val = number1.toDouble()
                    number2Val = number2.toDouble()
                    model.addAttribute("result", String.format("%.2f",number1Val+number2Val))
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "NumberError")
                    model.addAttribute("number1", number1)
                    model.addAttribute("number2", number2)
                }
            "multiply" ->
                try {
                    number1Val = number1.toDouble()
                    number2Val = number2.toDouble()
                    model.addAttribute("result", String.format("%.2f",number1Val*number2Val))
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "NumberError")
                    model.addAttribute("number1", number1)
                    model.addAttribute("number2", number2)
                }
            "divide" ->
                try {
                    number1Val = number1.toDouble()
                    number2Val = number2.toDouble()
                    model.addAttribute("result", String.format("%.2f",number1Val/number2Val))
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "NumberError")
                    model.addAttribute("number1", number1)
                    model.addAttribute("number2", number2)
                }
            "subtract" ->
                try {
                    number1Val = number1.toDouble()
                    number2Val = number2.toDouble()
                    model.addAttribute("result", String.format("%.2f",number1Val-number2Val))
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "NumberError")
                    model.addAttribute("number1", number1)
                    model.addAttribute("number2", number2)
                }
            else -> {
                model.addAttribute("error", "Other")
                model.addAttribute("number1", number1)
                model.addAttribute("number2", number2)
            }
        }
        return "home"
    }
}
