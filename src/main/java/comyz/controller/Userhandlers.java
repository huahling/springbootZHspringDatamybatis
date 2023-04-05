package comyz.controller;


import comyz.entities.Gs;
import comyz.entities.User;
import comyz.service.Userservice;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

@Controller
public class Userhandlers {

    @Autowired
    private Userservice userservice;


    @RequestMapping(value = "/query", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    public String query(Map<String, Object> map, String pageno, String pagesize) throws IOException {


        if (pageno == null || pageno.equals("")) {
            pageno = "0";
        }

        if (pagesize == null || pagesize.equals("")) {
            pagesize = "4";
        }


        int pagesize1 = Integer.valueOf(pagesize);
        int pageno1 = Integer.valueOf(pageno);
        int sum = userservice.counts(pagesize1);


//		System.out.println("--------------========"+sum);
        map.put("size", pagesize1);

        map.put("sums", sum);

        map.put("limits", pageno1);

        map.put("querys", userservice.queryUser(Integer.valueOf(pageno1), Integer.valueOf(pagesize)));
//		System.out.println("-----------------------------------"+userservice.queryUser());
        return "qu";
    }


    @RequestMapping(value = "/test", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    public void querya() throws IOException {
        System.out.println("--------------" + userservice.counts(4));
//		userservice.af();
    }


    // ɾ��
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") int id, String pageno, String pagesize) {

        int pagesize1 = Integer.valueOf(pagesize);
        int pageno1 = Integer.valueOf(pageno);

//		System.out.println("====="+userservice.qusid());
        userservice.delete(id);

        return "redirect:/query" + "?pageno=" + pageno1 + "&pagesize=" + pagesize1;
    }


//	@RequestMapping(value = "/query1", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
//	public String query1(Map<String, Object> map,String pageno,String pagesize) throws IOException {
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
//
//
//		int sum=  userservice.counts(pagesize1);
//		int pageno2=userservice.coun(pagesize1, pageno1);
//
//
//		map.put("size",pagesize1);
//		map.put("sums",sum);
//		System.out.println(pageno2);
//		System.out.println(pagesize);
//
//		map.put("limits",pageno2);
//
//		map.put("querys", userservice.queryUser(Integer.valueOf(pageno2),Integer.valueOf(pagesize)));
//
//		return "qu";
//	}


    @RequestMapping(value = "/shangye", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    public String shang(Map<String, Object> map, String pageno, String pagesize) throws IOException {

//		if( pageno == null || pageno.equals("")   && pagesize==null || pagesize.equals("") ) {
//
//			pageno="0";
//			pagesize="4";
//
//		}


        int pagesize1 = Integer.valueOf(pagesize);

        int sum = userservice.counts(pagesize1);

        map.put("size", pagesize1);
        map.put("sums", sum);


        map.put("limits", Integer.valueOf(pageno) - 1);

        map.put("querys", userservice.queryUser(Integer.valueOf(pageno) - 1, Integer.valueOf(pagesize)));

        return "qu";
    }

    @RequestMapping(value = "/xiaye", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    public String xia(Map<String, Object> map, String pageno, String pagesize) throws IOException {

        if (pageno == null || pageno.equals("") && pagesize == null || pagesize.equals("")) {

            pageno = "0";
            pagesize = "4";

        }


        int pagesize1 = Integer.valueOf(pagesize);
        ;


        int sum = userservice.counts(pagesize1);

        map.put("sums", sum);
        map.put("size", pagesize1);


        map.put("limits", Integer.valueOf(pageno) + 1);

        map.put("querys", userservice.queryUser(Integer.valueOf(pageno) + 1, Integer.valueOf(pagesize)));

        return "qu";
    }

    @RequestMapping(value = "/wei", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    public String wei(Map<String, Object> map, String pageno, String pagesize) throws IOException {


        int pagesize1 = Integer.valueOf(pagesize);
        int sum = userservice.counts(pagesize1);

        map.put("size", pagesize1);

        map.put("sums", sum);

        map.put("limits", Integer.valueOf(pageno) - 1);

        map.put("querys", userservice.queryUser(Integer.valueOf(pageno) - 1, Integer.valueOf(pagesize)));

        return "qu";
    }


    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/locat", method = RequestMethod.GET)
    public String lo(Map<String, Object> map, Locale locale) {

        messageSource.getMessage("td.xinbei", new Object[]{"fong", "nv"}, locale);// ���Դ�ֵ ����ֵ��

//		map.put("querys", userservice.queryUser());
        return "qu";
    }


    @RequestMapping("/locale")
    public String locale(Locale locale, Map<String, String> map) {
        map.put("lang", locale.toString());

        return "forward:/query";
    }


    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String add(Map<String, Object> map, Locale locale) {

        Map<String, String> xingbei = new HashMap();
        xingbei.put("0", messageSource.getMessage("td.na", null, locale));
        xingbei.put("1", messageSource.getMessage("td.nv", null, locale));

        map.put("xingbei", xingbei);

        List<Gs> li = userservice.qugs();

//		li.add();

//		System.out.println(li+"----------------");
        map.put("yg", li);

        map.put("user", new User());
        System.out.println("����get");
        return "add";
    }

    // �������ռ� ���ں�̨
    // ����

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addsave(@Validated User user, BindingResult bindingResult, @RequestParam("hd") MultipartFile file, Map<String, Object> map, Locale locale) throws Exception {

        if (bindingResult.getErrorCount() > 0) {
            List<FieldError> list = bindingResult.getFieldErrors();

            for (FieldError fieldError : list) {
                System.out.println(fieldError.getDefaultMessage());

            }
            Map<String, String> xingbei = new HashMap<String, String>();
            xingbei.put("0", messageSource.getMessage("td.na", null, locale));
            xingbei.put("1", messageSource.getMessage("td.nv", null, locale));
            map.put("xingbei", xingbei);

            List<Gs> li = userservice.qugs();


            map.put("yg", li);
            return "add";
        }

        String flname = file.getOriginalFilename();
        String strs[] = flname.split("\\.");
        String type = strs[strs.length - 1];
        String lujing = "E:\\test\\" + getName(type);
        FileOutputStream fileOutputStream = new FileOutputStream(lujing);

        InputStream inputStream = file.getInputStream();

        byte[] buff = new byte[1024];
        int le;

        while ((le = inputStream.read(buff)) != -1) {
            fileOutputStream.write(buff, 0, le);
        }

        fileOutputStream.close();
        inputStream.close();

        user.setHand(lujing);
        userservice.add(user);


        System.out.println("����");
//		System.out.println(user.toString());
        return "redirect:/query";
    }


    public synchronized String getName(String type) {
        return System.currentTimeMillis() + "." + type;
    }


    // �޸�
    @RequestMapping(value = "/emp/{id}", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    public String quid(@PathVariable("id") Integer id, Map<String, Object> map, HttpServletRequest request, HttpSession session, Locale locale) {

        User user = userservice.queryid(id);
//		System.out.println(user);
        map.put("user", user);

        Map<String, String> xingbei = new HashMap();
        xingbei.put("0", messageSource.getMessage("td.na", null, locale));
        xingbei.put("1", messageSource.getMessage("td.nv", null, locale));
        map.put("xingbei", xingbei);

        List<Gs> li = userservice.qugs();

        System.out.println("�޸�get");
        map.put("yg", li);

        return "add";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String updatesave(@Validated User user, BindingResult bindingResult, @RequestParam(value = "hd") MultipartFile file, Map<String, Object> map, Locale locale) throws Exception {

        if (bindingResult.getErrorCount() > 0) {

            List<FieldError> list = bindingResult.getFieldErrors();

            for (FieldError fieldError : list) {
//				System.out.println(fieldError.getDefaultMessage());
            }

            Map<String, String> xingbei = new HashMap();
            xingbei.put("0", messageSource.getMessage("td.na", null, locale));
            xingbei.put("1", messageSource.getMessage("td.nv", null, locale));
            map.put("xingbei", xingbei);

            List<Gs> li = userservice.qugs();

            map.put("yg", li);

            System.out.println("�޸�");
            return "add";
        }


        String flname = file.getOriginalFilename();
        String strs[] = flname.split("\\.");
        String type = strs[strs.length - 1];
        String lujing = "E:\\test\\" + getName(type);
        FileOutputStream fileOutputStream = new FileOutputStream(lujing);

        InputStream inputStream = file.getInputStream();

        byte[] buff = new byte[1024];
        int le;

        while ((le = inputStream.read(buff)) != -1) {
            fileOutputStream.write(buff, 0, le);
        }

        fileOutputStream.close();
        inputStream.close();

        user.setHand(lujing);

        System.out.println("�޸�put");

        userservice.update(user);
        return "redirect:/query";
    }


    @RequestMapping(value = "/chuan")
    public String files(@RequestParam("fils") MultipartFile[] files) throws Exception {

        for (MultipartFile file : files) {

            String flname = file.getOriginalFilename();
//		    System.out.println(flname);

            FileOutputStream fileOutputStream = new FileOutputStream("E:\\test\\" + flname);

            InputStream inputStream = file.getInputStream();
            byte[] buff = new byte[1024];
            int le;

            while ((le = inputStream.read(buff)) != -1) {
                fileOutputStream.write(buff, 0, le);
            }

            fileOutputStream.close();
            inputStream.close();
        }
//		redirect���¶���   ����·��   forwardת��   ��·��
//		���������Ͳ�ͬʱ���ض��� �ɲ���ͻ
        return "redirect:/query";
    }


    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
        if (id != null) {
            map.put("user", userservice.queryid(id));
        }
    }


    // ֻ����С�ļ� �����ṩ��
    @RequestMapping("/testxia")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session, String path) throws IOException {

        if (path != "" && path != null) {
            byte[] body = null;
//		ServletContext servletContext = session.getServletContext();

//		String str  = decodeURIComponent(path);
//		String spath=path;
//		 C:\\Users\\user\\Desktop
//		 C:\\Users\\user\\Desktop\\
            File file = new File(path);
//		"C:\\Users\\user\\Desktop\\jietu\\zhuomian.png"\\
            InputStream in = new FileInputStream(path);// spath
            body = new byte[in.available()];// һ�����������ڴ�
            in.read(body);

            HttpHeaders headers = new HttpHeaders();// ab.png
            headers.add("Content-Disposition", "attachment;filename=" + file.getName());// file.getName()

            HttpStatus statusCode = HttpStatus.OK;

            ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);

            return response;
        }
        return null;
    }


    // ���ļ�
    @RequestMapping(value = "testda", method = RequestMethod.GET)
    public void dff(HttpServletResponse response, String path) throws Exception {
//		String xiazai = "C:\\Users\\user\\Desktop\\jietu\\zhuomian.png";
//      URLEncoder.encode("ac.png", "UTF-8")

        File file = new File(path);
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());

        InputStream inputStream = new FileInputStream(path);

        byte[] bu = new byte[1024];

        OutputStream outputStream2 = response.getOutputStream();

//		int le= 0;
//		while((le=inputStream.read(bu)) !=-1) {
//
//			outputStream2.write(bu, 0, le);
//		}

        int le;
        while (true) {
            le = inputStream.read(bu);
            if (le == -1)
                break;
            outputStream2.write(bu, 0, le);
        }

        outputStream2.close();
        inputStream.close();

    }


    @RequestMapping(value = "/ru", method = RequestMethod.POST)//,@RequestParam("daoru") MultipartFile file
    public String ru() throws Exception {

//		String flname = file.getOriginalFilename();

//		InputStream in = new FileInputStream("C:\\Users\\user\\Desktop\\"+flname);
        InputStream in = new FileInputStream("C:\\Users\\user\\Desktop\\java工具\\biao.xlsm");

        XSSFWorkbook workbook = new XSSFWorkbook(in);

        int wo = workbook.getNumberOfSheets();

        for (int i = 0; i < wo; i++) {
            XSSFSheet sheets = workbook.getSheetAt(i);

            if (sheets != null) {
                List<User> list = new ArrayList<User>();
                int rows = sheets.getLastRowNum();

                for (int f = 1; f <= rows; f++) {

                    XSSFRow row = sheets.getRow(f);

                    if (row != null) {


                        XSSFCell cell2 = row.getCell(0);
                        XSSFCell cell3 = row.getCell(1);
                        XSSFCell cell4 = row.getCell(2);
                        XSSFCell cell5 = row.getCell(3);
                        XSSFCell cell6 = row.getCell(4);
                        XSSFCell cell7 = row.getCell(5);
                        XSSFCell cell8 = row.getCell(6);

//						User user =new User();

                        User user = new User();
                        Gs gs = new Gs();

                        user.setHand(getCellValue(cell2));
                        user.setName(getCellValue(cell3));
                        user.setSex(getCellValue(cell4));
                        user.setAddr(getCellValue(cell5));
                        user.setPassword(getCellValue(cell6));

                        Date setupTime = HSSFDateUtil.getJavaDate(Double.parseDouble(getCellValue(cell7)));
                        user.setBirth(setupTime);

                        gs.setSid(Integer.valueOf(getCellValue(cell8)));
                        user.setGs(gs);

//						user.setGs_id(Integer.valueOf(getCellValue(cell8)));
//						System.out.println(user);

                        list.add(user);

                    }

                }


                userservice.addlist(list);
            }

        }
        return "redirect:/query";

    }


    @RequestMapping(value = "/ru2", method = RequestMethod.POST)//,@RequestParam("daoru") MultipartFile file
    public String ru(@RequestParam("daoru") MultipartFile file) throws Exception {

        String flname = file.getOriginalFilename();

        InputStream in = new FileInputStream("C:\\Users\\user\\Desktop\\java工具\\" + flname);

        XSSFWorkbook workbook = new XSSFWorkbook(in);

        int wo = workbook.getNumberOfSheets();

        for (int i = 0; i < wo; i++) {
            XSSFSheet sheets = workbook.getSheetAt(i);

            if (sheets != null) {
                List<User> list = new ArrayList<User>();
                int rows = sheets.getLastRowNum();

                for (int f = 1; f <= rows; f++) {

                    XSSFRow row = sheets.getRow(f);

                    if (row != null) {


                        XSSFCell cell2 = row.getCell(0);
                        XSSFCell cell3 = row.getCell(1);
                        XSSFCell cell4 = row.getCell(2);
                        XSSFCell cell5 = row.getCell(3);
                        XSSFCell cell6 = row.getCell(4);
                        XSSFCell cell7 = row.getCell(5);
                        XSSFCell cell8 = row.getCell(6);

                        User user = new User();
                        Gs gs = new Gs();

                        user.setHand(getCellValue(cell2));
                        user.setName(getCellValue(cell3));
                        user.setSex(getCellValue(cell4));
                        user.setAddr(getCellValue(cell5));
                        user.setPassword(getCellValue(cell6));

                        Date setupTime = HSSFDateUtil.getJavaDate(Double.parseDouble(getCellValue(cell7)));
                        user.setBirth(setupTime);

                        gs.setSid(Integer.valueOf(getCellValue(cell8)));
                        user.setGs(gs);


//						System.out.println(user);
                        list.add(user);

                    }

                }

                userservice.addlist(list);
            }

        }
        return "redirect:/query";

    }


    public String getCellValue(Cell cell) {

        if (cell == null)
            return "";

        if (cell.getCellTypeEnum() == CellType.STRING) {

            return cell.getStringCellValue();

        } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {

            return String.valueOf(cell.getBooleanCellValue());

        } else if (cell.getCellTypeEnum() == CellType.FORMULA) {

            return cell.getCellFormula();

        } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {

            return String.valueOf(cell.getNumericCellValue());

        }
        return "";
    }


    @RequestMapping(value = "/dd", method = RequestMethod.POST)
    public String ts() {

        return "zai";
    }

    @RequestMapping(value = "/ts", method = RequestMethod.POST)
    public String tf() {
        return "test";
    }

    @RequestMapping(value = "/aa")
    public String ac() {
//		System.out.println("aa +RequestMapping");
        return "userView";
    }

//	@InitBinder
//	public void initbinder(WebDataBinder dataBinder) {
//
////		System.out.println("Initbinder");
////		System.out.println("Webdatabinder");
//
//		// ʱ��ת��
////		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////	     dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
//
////	     dataBinder.setDisallowedFields("addr");
//	}


    @RequestMapping(value = "dao", method = RequestMethod.POST)
    public void df(HttpServletResponse response) throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("user");

        sheet.setColumnWidth(0, 10 * 256);
        sheet.setColumnWidth(1, 10 * 256);
        sheet.setColumnWidth(2, 15 * 256);
        sheet.setColumnWidth(3, 15 * 256);
        sheet.setColumnWidth(4, 20 * 256);

        XSSFRow row = sheet.createRow(0);

        XSSFCell cell = row.createCell(0);
        XSSFCell cell1 = row.createCell(1);
        XSSFCell cell2 = row.createCell(2);
        XSSFCell cell3 = row.createCell(3);
        XSSFCell cell4 = row.createCell(4);
        XSSFCell cell5 = row.createCell(5);
        XSSFCell cell6 = row.createCell(6);
        XSSFCell cell7 = row.createCell(7);

        cell.setCellValue("ID");
        cell1.setCellValue("hand");
        cell2.setCellValue("name");
        cell3.setCellValue("sex");
        cell4.setCellValue("addr");
        cell5.setCellValue("password");
        cell6.setCellValue("birth");
        cell7.setCellValue("gs_id");
        List<User> list = userservice.queryUser();

        for (int i = 0; i < list.size(); i++) {

            XSSFRow biao = sheet.createRow(i + 1);
//		XSSFCell cell00 = biao.createCell(0);
            XSSFCell cell10 = biao.createCell(0);
            XSSFCell cell11 = biao.createCell(1);
            XSSFCell cell22 = biao.createCell(2);
            XSSFCell cell33 = biao.createCell(3);
            XSSFCell cell44 = biao.createCell(4);
            XSSFCell cell55 = biao.createCell(5);
            XSSFCell cell66 = biao.createCell(6);
            XSSFCell cell77 = biao.createCell(7);

//		cell00.setCellValue("ID");
//		cell00.setCellValue("name");
//		cell00.setCellValue("sex");
//		cell00.setCellValue("addr");
//		cell00.setCellValue("birth");
//		cell00.setCellValue("password");
//		cell00.setCellValue("yuangong");
            User bo = list.get(i);
            Gs gs = new Gs();

            cell10.setCellValue(bo.getId());
            cell11.setCellValue(bo.getHand());
            cell22.setCellValue(bo.getName());
            cell33.setCellValue(bo.getSex());
            cell44.setCellValue(bo.getAddr());
            cell55.setCellValue(bo.getPassword());
            cell66.setCellValue(bo.getBirth());

            cell77.setCellValue(bo.getGs().getSid());

        }


        String as = "C:/Users/user/Desktop/biao.xlsx";

        FileOutputStream fileOutputStream = new FileOutputStream(as);
        workbook.write(fileOutputStream);
        fileOutputStream.close();

//		String xiazai = "C:\\Users\\user\\Desktop\\aa.xlsm";
//
//		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("bb.xlsx", "UTF-8"));
//
//		InputStream inputStream = new FileInputStream(xiazai);
//
//		int len = 0;
//		byte[] buff = new byte[1024];
//
//		OutputStream outputStream = response.getOutputStream();
//		while ((len = inputStream.read(buff)) != -1) {
//			outputStream.write(buff, 0, len);
//
//		}
//
//		outputStream.close();
//		inputStream.close();

    }


}
