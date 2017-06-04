package com.example.demo.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Bean;
import com.example.demo.entity.TimeStampBean;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class indexController {

	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	private static final SimpleDateFormat SDF_TIME = new SimpleDateFormat("HH:mm");


	@RequestMapping("/index")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = "json")
	@ResponseBody
	public List<Bean> getTestData(@RequestParam("time") String time, @RequestParam("date") String date) {

		log.info("call getTestData");

		List<TimeStampBean> timeBeanList = indexController.newTimeStampBeanList();
		List<Bean> beanList = indexController.newBeanList();

		List<Bean> list = new ArrayList<>();
		Timestamp ts = null;

		try {
			Timestamp getTs = new Timestamp(SDF.parse(date + " " + time).getTime());
			for (int i = 0; i < timeBeanList.size(); i++) {
				ts = timeBeanList.get(i).getTime();
				if (getTs.equals(ts)) {
					//時間が一致したものだけをリストに格納
					String formatTime = SDF_TIME.format(ts);
					list.add(new Bean(beanList.get(i).getId(), beanList.get(i).getName(), formatTime));
				}
			}
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * TimeStampBeanを20個インスタンス生成して返す
	 *
	 * @return
	 */
	private static List<TimeStampBean> newTimeStampBeanList() {
		log.info("call newTimeStampBeanlist");

		List<TimeStampBean> list = new ArrayList<>();

		try {
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 8:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 8:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 9:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 10:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 10:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 10:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 12:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 12:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 13:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 14:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 14:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 14:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 15:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 16:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 16:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 17:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 18:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 22:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 23:00").getTime())));
			list.add(new TimeStampBean(new Timestamp(SDF.parse("2017/6/4 24:00").getTime())));
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Beanを20個インスタンス生成して返す
	 *
	 * @return
	 */
	private static List<Bean> newBeanList() {
		log.info("call newBeanList");

		List<Bean> list = new ArrayList<>();

		list.add(new Bean(1, "aaa"));
		list.add(new Bean(2, "bbb"));
		list.add(new Bean(3, "ccc"));
		list.add(new Bean(4, "ddd"));
		list.add(new Bean(5, "eee"));
		list.add(new Bean(6, "fff"));
		list.add(new Bean(7, "ggg"));
		list.add(new Bean(8, "hhh"));
		list.add(new Bean(9, "iii"));
		list.add(new Bean(10, "jjj"));
		list.add(new Bean(11, "kkk"));
		list.add(new Bean(12, "lll"));
		list.add(new Bean(13, "mmm"));
		list.add(new Bean(14, "nnn"));
		list.add(new Bean(15, "ooo"));
		list.add(new Bean(16, "ppp"));
		list.add(new Bean(17, "qqq"));
		list.add(new Bean(18, "rrr"));
		list.add(new Bean(19, "sss"));
		list.add(new Bean(20, "ttt"));

		return list;
	}
}
