package ro.fabio.controller;

import java.time.MonthDay;

import static org.joda.time.DateTime.now;
import java.util.Date;
import org.joda.time.*;

import static org.joda.time.format.ISODateTimeFormat.date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.fabio.entity.Licitatie;
import ro.fabio.service.LicitatieService;

@Controller
@RequestMapping("licitatie")
public class LicitatieController {

	@Autowired
	private LicitatieService licitatieService;

	
	
	@RequestMapping("/detalii")
	public String doIndexPage(Model model,@RequestParam int licitatie_id) {

		model.addAttribute("licitatie",licitatieService.findOne(licitatie_id));
		return "detalii_licitatie";
	}

	
	private static Licitatie convertRecordsToChatFormat(Licitatie lic) {
            StringBuilder licitatieTime = new StringBuilder();
            DateTime recordDateTime = new DateTime(lic.getStartTime().getTime());
            Hours hours = Hours.hoursBetween(recordDateTime , now());
            if (hours.getHours() > 0) {
                Years years = Years.yearsBetween(recordDateTime , now());
                MonthDay day = MonthDay.fromDateFields(new Date(now().getMillis() - recordDateTime.getMillis()));
                int hour = Hours.hoursBetween(recordDateTime, now()).getHours() % 24;
                if (years.getYears() == 1) {
                    licitatieTime.append(" 1 year ");
                }else if(years.getYears() > 1){
                    licitatieTime.append(years.getYears()).append(" years ");
                }
                if (day.getMonthValue() == 2) {
                    licitatieTime.append(" 1 month ");
                } else if (day.getMonthValue() > 2) {
                    licitatieTime.append(day.getMonthValue()).append(" months ");
                }
                if (day.getDayOfMonth() > 1) {
                    licitatieTime.append(" 1 day ");
                } else if (day.getDayOfMonth() > 2) {
                    licitatieTime.append(day.getDayOfMonth()).append(" days ");
                }
                if (hour == 1) {
                    licitatieTime.append(" 1 hour ");
                } else if (hour > 1) {
                    licitatieTime.append(hour).append(" hours ");
                }
                licitatieTime.append("old");
            } else {
                licitatieTime.append("now");
            }

            lic.setStartTime(null);
        }

        return lic;
    }

}
