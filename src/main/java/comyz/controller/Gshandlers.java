//package comyz.controller;
//
//import comyz.entities.Gs;
//import comyz.service.Userservice;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//
//@Controller
//public class Gshandlers {
//
//	@Autowired
//	private Userservice userservice;
//
//
//
//	@RequestMapping(value = "/quGs", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
//	public String queryGs(Map<String, Object> map,String pageno,String pagesize) throws IOException {
//
//
//		if( pageno == null || pageno.equals("") ) {
//			pageno="0";
//		}
//
//		if(pagesize==null || pagesize.equals("") ) {
//			pagesize="4";
//		}
//
//
//		int pagesize1 = Integer.valueOf(pagesize);
//		int pageno1 = Integer.valueOf(pageno);
//		int sum=  userservice.countsgs(pagesize1);
//
//		map.put("size", pagesize1);
//		map.put("sums",sum);
//
//
//		map.put("ins",userservice.pdd());
//
//		map.put("limits",pageno1);
//
//
//		map.put("querys", userservice.qugsfeng(Integer.valueOf(pageno1),Integer.valueOf(pagesize)));
//
//		return "quGs";
//	}
//
////	@RequestMapping(value = "/quGs2", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
////	public String queryGs2(Map<String, Object> map,String pageno,String pagesize) throws IOException {
////
////
////		if( pageno == null || pageno.equals("") ) {
////			pageno="0";
////		}
////
////		if(pagesize==null || pagesize.equals("") ) {
////			pagesize="4";
////		}
////
////
////		int pagesize1 = Integer.valueOf(pagesize);
////		int pageno1 = Integer.valueOf(pageno);
////		int sum=  userservice.countsgs(pagesize1);
////
////		map.put("size", pagesize1);
////		map.put("sums",sum);
////
////
////		map.put("limits",pageno1);
////
////
////		map.put("querys", userservice.qugsfeng(Integer.valueOf(pageno1),Integer.valueOf(pagesize)));
////
////		return "quGs2";
////	}
//
//	@RequestMapping(value = "/gs/{sid}", method = RequestMethod.DELETE)
//	public String deletegs(@PathVariable(value ="sid") int sid,Map<String, Object> map,String pageno,String pagesize) {
//
//		int pagesize1 = Integer.valueOf(pagesize);
//		int pageno1=  Integer.valueOf(pageno);
//
//		List<Integer> in = userservice.pdd();
////
////
//		userservice.deletegs(sid);
//
//		return "redirect:/quGs"+"?pageno="+pageno1+"&pagesize="+pagesize1;
//	}
//
//
//	@RequestMapping(value = "/gs", method = RequestMethod.GET)
//	public String addgs(Map<String, Object> map) {
//
//		System.out.println("___________");
//		map.put("gs", new Gs());
//		return "addGs";
//	}
//
////		@RequestMapping(value = "/erorr")
////		public String err() {
////
////			return "erorr";
////		}
//
//
//
//
//
//	// ������˾
//	@RequestMapping(value ="/gs", method = RequestMethod.POST)
//	public String addgs(@Validated Gs gs,Map<String, Object> map,BindingResult bindingResult) throws Exception {
//
//
//		userservice.addgss(gs);
//		System.out.println("������˾"+gs);
//
//		return "redirect:/quGs";
//	}
//
//
//
//	// �޸Ĺ�˾
//	@RequestMapping(value = "/gs/{sid}", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
//	public String gsxiu(@PathVariable("sid") Integer sid, Map<String, Object> map,HttpServletRequest request,HttpSession session, Locale locale) {
//
//		Gs gs = userservice.quidgs(sid);
////					System.out.println(user);
//		map.put("gs",gs);
//					List<Gs> li = userservice.qugs();
//		System.out.println("�޸Ĺ�˾"+gs);
//					map.put("yg", li);
//
//		return "addGs";
//	}
//
//	@RequestMapping(value = "/gs",method = RequestMethod.PUT)
//	public String updateGssave(@Validated Gs gs, BindingResult bindingResult,Map<String, Object> map,Locale locale) throws Exception {
//
//		System.out.println("��˾"+gs);
//		userservice.updateGss(gs);
//
////					System.out.println("�޸Ĺ�˾");
//		return "redirect:/quGs";
//	}
//
//
//
//	@RequestMapping(value = "/shangyegs", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
//	public String shang(Map<String, Object> map,String pageno,String pagesize) throws IOException {
//
////		if( pageno == null || pageno.equals("")   && pagesize==null || pagesize.equals("") ) {
////
////			pageno="0";
////			pagesize="4";
////
////		}
//
//
//
//		int pagesize1 = Integer.valueOf(pagesize);
//
//		int sum=  userservice.countsgs(pagesize1);
//
//		map.put("size", pagesize1);
//		map.put("sums",sum);
//		map.put("ins",userservice.pdd());
//
//		map.put("limits",Integer.valueOf(pageno)-1);
//
//		map.put("querys", userservice.qugsfeng(Integer.valueOf(pageno)-1,Integer.valueOf(pagesize)));
//
//		return "quGs";
//	}
//
//	@RequestMapping(value ="/xiayegs", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
//	public String xia(Map<String, Object> map,String pageno,String pagesize) throws IOException {
//
//		if( pageno == null || pageno.equals("")   && pagesize==null || pagesize.equals("") ) {
//
//			pageno="0";
//			pagesize="4";
//
//		}
//
//
//
//		int pagesize1 = Integer.valueOf(pagesize);;
//
//
//
//		int sum=  userservice.countsgs(pagesize1);
//
//		map.put("sums",sum);
//		map.put("size", pagesize1);
//		map.put("ins",userservice.pdd());
//
//
//		map.put("limits",Integer.valueOf(pageno)+1);
//
//		map.put("querys", userservice.qugsfeng(Integer.valueOf(pageno)+1,Integer.valueOf(pagesize)));
//
//		return "quGs";
//	}
//
//	@RequestMapping(value = "/weigs", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
//	public String wei(Map<String, Object> map,String pageno,String pagesize) throws IOException {
//
//
//		int pagesize1 = Integer.valueOf(pagesize);
//		int sum=  userservice.countsgs(pagesize1);
//
//		map.put("size", pagesize1);
//
//		map.put("ins",userservice.pdd());
//		map.put("sums",sum);
//
//		map.put("limits",Integer.valueOf(pageno)-1);
//
//		map.put("querys", userservice.qugsfeng(Integer.valueOf(pageno)-1,Integer.valueOf(pagesize)));
//
//		return "quGs";
//	}
//
//
//
//	@RequestMapping("/localeGs")
//	public String locales(Locale locale, Map<String, String> map) {
//		map.put("lang", locale.toString());
//
//		return "forward:/quGs";
//	}
//
//
//
//
//
//
//
//}
