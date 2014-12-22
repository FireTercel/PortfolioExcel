package poi.bean;


/**
 * 经转关系初始化类
 * 
 * @author 唐东宇
 *  
 */
public class CodeInit { 
	private CodeTree[] codetrees; 

	public CodeTree[] getCodetrees() {
		return codetrees;
	}

	public void setCodetrees(CodeTree[] codetrees) {
		this.codetrees = codetrees;
	}

	/**
	 * 省内各地市以及经济出口经转关系匹配。 
	 * 
	 * @return
	 */
	public CodeTree[] initCodeForPostroad() {

		this.codetrees = new CodeTree[44];
		codetrees[0] = new CodeTree();
		codetrees[0].setNodeName("湛江");
		String[] subNames00 = { "52400000" };
		codetrees[0].setSubNames(subNames00);
		codetrees[0].setCount(0);
		codetrees[0].setWeights(0);
		// ---------------------------------------
		codetrees[1] = new CodeTree();
		codetrees[1].setNodeName("茂名");
		String[] subNames01 = { "52500000" };
		codetrees[1].setSubNames(subNames01);
		codetrees[1].setCount(0);
		codetrees[1].setWeights(0);
		// ---------------------------------------
		codetrees[2] = new CodeTree();
		codetrees[2].setNodeName("阳江 阳春");
		String[] subNames02 = { "52950000","52960000" };
		codetrees[2].setSubNames(subNames02);
		codetrees[2].setCount(0);
		codetrees[2].setWeights(0);
		// ---------------------------------------
		codetrees[3] = new CodeTree();
		codetrees[3].setNodeName("云浮");
		String[] subNames03 = { "52730000" };
		codetrees[3].setSubNames(subNames03);
		codetrees[3].setCount(0);
		codetrees[3].setWeights(0);
		// ---------------------------------------
		codetrees[4] = new CodeTree();
		codetrees[4].setNodeName("肇庆");
		String[] subNames04 = { "52600000" };
		codetrees[4].setSubNames(subNames04);
		codetrees[4].setCount(0);
		codetrees[4].setWeights(0);
		// ---------------------------------------
		codetrees[5] = new CodeTree();
		codetrees[5].setNodeName("江门");
		String[] subNames05 = { "52900000" };
		codetrees[5].setSubNames(subNames05);
		codetrees[5].setCount(0);
		codetrees[5].setWeights(0);
		// ---------------------------------------
		codetrees[6] = new CodeTree();
		codetrees[6].setNodeName("佛山");
		String[] subNames06 = { "52800000" };
		codetrees[6].setSubNames(subNames06);
		codetrees[6].setCount(0);
		codetrees[6].setWeights(0);
		// ---------------------------------------
		codetrees[7] = new CodeTree();
		codetrees[7].setNodeName("南海");
		String[] subNames07 = { "52820000" };
		codetrees[7].setSubNames(subNames07);
		codetrees[7].setCount(0);
		codetrees[7].setWeights(0);
		// ---------------------------------------
		codetrees[8] = new CodeTree();
		codetrees[8].setNodeName("三水");
		String[] subNames08 = { "52810000" };
		codetrees[8].setSubNames(subNames08);
		codetrees[8].setCount(0);
		codetrees[8].setWeights(0);
		// ---------------------------------------
		codetrees[9] = new CodeTree();
		codetrees[9].setNodeName("顺德");
		String[] subNames09 = { "52830000" };
		codetrees[9].setSubNames(subNames09);
		codetrees[9].setCount(0);
		codetrees[9].setWeights(0);
		// ---------------------------------------
		codetrees[10] = new CodeTree();
		codetrees[10].setNodeName("广州");
		//广州 广州国际
		String[] subNames10 = { "51000000","51003100" };
		codetrees[10].setSubNames(subNames10);
		codetrees[10].setCount(0);
		codetrees[10].setWeights(0);
		// ---------------------------------------
		codetrees[11] = new CodeTree();
		codetrees[11].setNodeName("番禺");
		String[] subNames11 = { "51140000" };
		codetrees[11].setSubNames(subNames11);
		codetrees[11].setCount(0);
		codetrees[11].setWeights(0);
		// ---------------------------------------
		codetrees[12] = new CodeTree();
		codetrees[12].setNodeName("中山");
		String[] subNames12 = { "52840000" };
		codetrees[12].setSubNames(subNames12);
		codetrees[12].setCount(0);
		codetrees[12].setWeights(0);
		// ---------------------------------------
		codetrees[13] = new CodeTree();
		codetrees[13].setNodeName("清远");
		String[] subNames13 = { "51150000" };
		codetrees[13].setSubNames(subNames13);
		codetrees[13].setCount(0);
		codetrees[13].setWeights(0);
		// ---------------------------------------
		codetrees[14] = new CodeTree();
		codetrees[14].setNodeName("韶关");
		String[] subNames14 = { "51200000" };
		codetrees[14].setSubNames(subNames14);
		codetrees[14].setCount(0);
		codetrees[14].setWeights(0);
		// ---------------------------------------
		codetrees[15] = new CodeTree();
		codetrees[15].setNodeName("东莞");
		String[] subNames15 = { "52300000" };
		codetrees[15].setSubNames(subNames15);
		codetrees[15].setCount(0);
		codetrees[15].setWeights(0);
		// ---------------------------------------
		codetrees[16] = new CodeTree();
		codetrees[16].setNodeName("深圳");
		//深圳 深圳国际
		String[] subNames16 = { "51800000","51805300","51805000" };
		codetrees[16].setSubNames(subNames16);
		codetrees[16].setCount(0);
		codetrees[16].setWeights(0);
		// ---------------------------------------
		codetrees[17] = new CodeTree();
		codetrees[17].setNodeName("惠州");
		String[] subNames17 = { "51600000" };
		codetrees[17].setSubNames(subNames17);
		codetrees[17].setCount(0);
		codetrees[17].setWeights(0);
		// ---------------------------------------
		codetrees[18] = new CodeTree();
		codetrees[18].setNodeName("汕尾");
		String[] subNames18 = { "51660000" };
		codetrees[18].setSubNames(subNames18);
		codetrees[18].setCount(0);
		codetrees[18].setWeights(0);
		// ---------------------------------------
		codetrees[19] = new CodeTree();
		codetrees[19].setNodeName("潮州");
		String[] subNames19 = { "52100000" };
		codetrees[19].setSubNames(subNames19);
		codetrees[19].setCount(0);
		codetrees[19].setWeights(0);
		// ---------------------------------------
		codetrees[20] = new CodeTree();
		codetrees[20].setNodeName("揭阳普宁");
		String[] subNames20 = { "52200000", "51530000" };
		codetrees[20].setSubNames(subNames20);
		codetrees[20].setCount(0);
		codetrees[20].setWeights(0);
		// ---------------------------------------
		codetrees[21] = new CodeTree();
		codetrees[21].setNodeName("汕头");
		String[] subNames21 = { "51500000" };
		codetrees[21].setSubNames(subNames21);
		codetrees[21].setCount(0);
		codetrees[21].setWeights(0);
		// ---------------------------------------
		codetrees[22] = new CodeTree();
		codetrees[22].setNodeName("梅州");
		String[] subNames22 = { "51400000" };
		codetrees[22].setSubNames(subNames22);
		codetrees[22].setCount(0);
		codetrees[22].setWeights(0);
		// ---------------------------------------
		codetrees[23] = new CodeTree();
		codetrees[23].setNodeName("河源");
		String[] subNames23 = { "51700000" };
		codetrees[23].setSubNames(subNames23);
		codetrees[23].setCount(0);
		codetrees[23].setWeights(0);
		// ---------------------------------------
		codetrees[24] = new CodeTree();
		codetrees[24].setNodeName("佛冈英德");
		String[] subNames24 = { "51160000", "51300000" };
		codetrees[24].setSubNames(subNames24);
		codetrees[24].setCount(0);
		codetrees[24].setWeights(0);
		// ---------------------------------------
		codetrees[25] = new CodeTree();
		codetrees[25].setNodeName("珠海");
		String[] subNames25 = { "51900000" };
		codetrees[25].setSubNames(subNames25);
		codetrees[25].setCount(0);
		codetrees[25].setWeights(0);
		// ---------------------------------------
		// 省际路向。==长沙==
		codetrees[26] = new CodeTree();
		codetrees[26].setNodeName("长沙");
		//长沙 岳阳 常德 娄底 怀化 衡阳 邵阳 郴州 永州 湘潭 株洲 吉首
		String[] subNames26 = { "41000000", "41500000", "42300000",
				"42100000", "41800000", "41700000", "42200000", "41110000",
				"42500000", "41400000", "41200000", "41600000" };

		codetrees[26].setSubNames(subNames26);
		codetrees[26].setCount(0);
		codetrees[26].setWeights(0);
		// ---------------------------------------
		// 省际路向。==无锡==
		codetrees[27] = new CodeTree();
		codetrees[27].setNodeName("无锡");
		String[] subNames27 = { "24600000", "23300000", "21300000", "23600000",
				"23000000", "31300000", "22300000", "24500000", "21440000",
				"22200000", "21000000", "22600000", "20000000", "31200000",
				"21500000", "23400000", "22530000", "21400000", "24100000",
				"22100000", "22400000", "22500000", "21200000", "22320000" };

		codetrees[27].setSubNames(subNames27);
		codetrees[27].setCount(0);
		codetrees[27].setWeights(0);
		// ---------------------------------------
		// 省际路向。==杭州==
		codetrees[28] = new CodeTree();
		codetrees[28].setNodeName("杭州");
		String[] subNames28 = { "31000000", "31400000", "32100000", "31500000",
				"32400000", "31800000", "32500000" };

		codetrees[28].setSubNames(subNames28);
		codetrees[28].setCount(0);
		codetrees[28].setWeights(0);
		// ---------------------------------------
		// 省际路向。==成都==
		codetrees[29] = new CodeTree();
		codetrees[29].setNodeName("成都");
		String[] subNames29 = { "61000000", "63500000", "85000000", "61400000",
				"64600000", "62100000", "64100000", "63700000", "61500000",
				"64400000", "40000000","61002500" };

		codetrees[29].setSubNames(subNames29);
		codetrees[29].setCount(0);
		codetrees[29].setWeights(0);
		// ---------------------------------------
		// 省际路向。==济南==
		codetrees[30] = new CodeTree();
		codetrees[30].setNodeName("济南");
		// 德州 菏泽 济南 济宁 聊城 临沂 青岛 泰安 潍坊 薛城 烟台 枣庄 淄博 青岛国际 济南国际 烟台国际 威海国际
		String[] subNames30 = { "25300000", "27400000", "25000000", "27200000",
				"25200000", "27600000", "26600000", "27100000", "26100000",
				"27700000", "26400000", "27710000", "25500000"    ,"26603700","25004300","26404200","26423800" };

		codetrees[30].setSubNames(subNames30);
		codetrees[30].setCount(0);
		codetrees[30].setWeights(0);
		// ---------------------------------------
		// 省际路向。==昆明==
		codetrees[31] = new CodeTree();
		codetrees[31].setNodeName("昆明");
		String[] subNames31 = { "65000000" };
		codetrees[31].setSubNames(subNames31);
		codetrees[31].setCount(0);
		codetrees[31].setWeights(0);
		// ---------------------------------------
		// 省际路向。==西安==
		codetrees[32] = new CodeTree();
		codetrees[32].setNodeName("西安");
		String[] subNames32 = { "72500000", "72100000", "72300000", "73500000",
				"84400000", "84100000", "73000000", "74100000", "83000000",
				"71000000", "81000000", "71200000", "71600000", "75000000" ,"71004200" ,"83004400","73004400","75003800"};
		codetrees[32].setSubNames(subNames32);
		codetrees[32].setCount(0);
		codetrees[32].setWeights(0);
		// ---------------------------------------
		// 省际路向。==武汉==
		codetrees[33] = new CodeTree();
		codetrees[33].setNodeName("武汉");
		String[] subNames33 = { "44200000", "43000000", "44100000", "44300000", "43032100" };
		codetrees[33].setSubNames(subNames33);
		codetrees[33].setCount(0);
		codetrees[33].setWeights(0);
		// ---------------------------------------
		// 省际路向。==郑州==
		codetrees[34] = new CodeTree();
		codetrees[34].setNodeName("郑州");
		String[] subNames34 = { "45500000", "47100000", "46200000", "47300000",
				"47600000", "45300000", "45000000", "46300000", "46400000" };
		codetrees[34].setSubNames(subNames34);
		codetrees[34].setCount(0);
		codetrees[34].setWeights(0);
		// ---------------------------------------
		// 省际路向。==南昌==
		codetrees[35] = new CodeTree();
		codetrees[35].setNodeName("南昌");
		String[] subNames35 = { "34400000", "34100000", "34300000", "33300000",
				"33200000", "33000000", "33700000", "33400000", "33800000",
				"33600000", "33500000" };
		codetrees[35].setSubNames(subNames35);
		codetrees[35].setCount(0);
		codetrees[35].setWeights(0);
		// ---------------------------------------
		// 省际路向。==南宁==
		codetrees[36] = new CodeTree();
		codetrees[36].setNodeName("南宁");
		String[] subNames36 = { "54100000", "54500000", "53000000", "53700000",
				"54300000", "53500000" };
		codetrees[36].setSubNames(subNames36);
		codetrees[36].setCount(0);
		codetrees[36].setWeights(0);
		// ---------------------------------------
		// 省际路向。==贵阳==
		codetrees[37] = new CodeTree();
		codetrees[37].setNodeName("贵阳");
		// 贵阳 六盘水 遵义 贵阳国际
		String[] subNames37 = { "55000000", "55300000", "56300000" ,"55004500"};
		codetrees[37].setSubNames(subNames37);
		codetrees[37].setCount(0);
		codetrees[37].setWeights(0);
		// ---------------------------------------
		// 省际路向。==福州==
		codetrees[38] = new CodeTree();
		codetrees[38].setNodeName("福州");
		String[] subNames38 = { "35000000", "36400000", "35300000", "36200000",
				"36500000", "36100000", "36300000", "35030000", "35110000","36104800","35004900" };
		codetrees[38].setSubNames(subNames38);
		codetrees[38].setCount(0);
		codetrees[38].setWeights(0);
		// ---------------------------------------
		// 省际路向。==海口==
		codetrees[39] = new CodeTree();
		codetrees[39].setNodeName("海口");
		String[] subNames39 = { "57000000" };
		codetrees[39].setSubNames(subNames39);
		codetrees[39].setCount(0);
		codetrees[39].setWeights(0);
		// ---------------------------------------
		// 省际路向。==棠溪1==
		codetrees[40] = new CodeTree();
		codetrees[40].setNodeName("棠溪1");
		String[] subNames40 = { "01400000", "07100000", "10000000", "06100000",
				"04600000", "06700000", "02400000", "03700000", "05600000",
				"05300000", "04300000", "01000000", "06500000", "06600000",
				"05000000", "03000000", "06300000", "30000000", "02800000",
				"05400000", "07500000", "11300000", "11500000", "11000000",
				"12100000", "11800000", "11400000", "11600000", "11700000",
				"11100000" };
		codetrees[40].setSubNames(subNames40);
		codetrees[40].setCount(0);
		codetrees[40].setWeights(0);
		// ---------------------------------------
		// 省际路向。==棠溪2==
		codetrees[41] = new CodeTree();
		codetrees[41].setNodeName("棠溪2");
		String[] subNames41 = { "13000000", "15000000", "13200000", "15400000",
				"15700000", "16100000", "13300000", "02100000" };
		codetrees[41].setSubNames(subNames41);
		codetrees[41].setCount(0);
		codetrees[41].setWeights(0);
		// ---------------------------------------
		// 中山三角。
		codetrees[42] = new CodeTree();
		codetrees[42].setNodeName("中山三角");
		String[] subNames42 = {"52840100"};
		codetrees[42].setSubNames(subNames42);
		codetrees[42].setCount(0);
		codetrees[42].setWeights(0);
		// ---------------------------------------
		// 未知的事物，总是让人感到恐惧。
		codetrees[43] = new CodeTree();
		codetrees[43].setNodeName("其他未知");
		String[] subNames43 = null;
		codetrees[43].setSubNames(subNames43);
		codetrees[43].setCount(0);
		codetrees[43].setWeights(0);

		// 测试打印初始化内容
		/*for (int i = 0; i < codetrees.length; i++) {
			System.out.println(codetrees[i].toString());
		}*/

		return codetrees;

	}

	/**
	 * 省际出口流量
	 * 
	 * @author 唐东宇
	 * @return
	 */
	public CodeTree[] initCodeForOutPro() {
		this.codetrees = new CodeTree[32];

		// ---------------------------------------
		// 省内路向。==广西==
		codetrees[0] = new CodeTree();
		codetrees[0].setNodeName("广西");
		// 桂林 柳州 南宁 玉林 梧州 钦州
		String[] subNames00 = { "54100000", "54500000", "53000000", "53700000",
				"54300000", "53500000" };
		codetrees[0].setSubNames(subNames00);
		codetrees[0].setCount(0);
		codetrees[0].setWeights(0);

		// ---------------------------------------
		// 省际路向。==海南==
		codetrees[1] = new CodeTree();
		codetrees[1].setNodeName("海南");
		// 海口
		String[] subNames01 = { "57000000" };
		codetrees[1].setSubNames(subNames01);
		codetrees[1].setCount(0);
		codetrees[1].setWeights(0);

		// ---------------------------------------
		// 省际路向。==贵州==
		codetrees[2] = new CodeTree();
		codetrees[2].setNodeName("贵州");
		// 贵阳 六盘水 遵义 贵阳国际
		String[] subNames02 = { "55000000", "55300000", "56300000","55004500" };
		codetrees[2].setSubNames(subNames02);
		codetrees[2].setCount(0);
		codetrees[2].setWeights(0);

		// ---------------------------------------
		// 省际路向。==江西==
		codetrees[3] = new CodeTree();
		codetrees[3].setNodeName("江西");
		// 抚州 赣州 吉安 景德镇 九江 南昌 萍乡 上饶 新余 宜春 鹰潭
		String[] subNames03 = { "34400000", "34100000", "34300000", "33300000",
				"33200000", "33000000", "33700000", "33400000", "33800000",
				"33600000", "33500000" };
		codetrees[3].setSubNames(subNames03);
		codetrees[3].setCount(0);
		codetrees[3].setWeights(0);

		// ---------------------------------------
		// 省际路向。==山东==
		codetrees[4] = new CodeTree();
		codetrees[4].setNodeName("山东");
		// 德州 菏泽 济南 济宁 聊城 临沂 青岛 泰安 潍坊 薛城 烟台 枣庄 淄博 青岛国际 济南国际 烟台国际 威海国际
		String[] subNames04 = { "25300000", "27400000", "25000000", "27200000",
				"25200000", "27600000", "26600000", "27100000", "26100000",
				"27700000", "26400000", "27710000", "25500000" ,"26603700","25004300","26404200","26423800"};
		codetrees[4].setSubNames(subNames04);
		codetrees[4].setCount(0);
		codetrees[4].setWeights(0);

		// ---------------------------------------
		// 省际路向。==四川==
		codetrees[5] = new CodeTree();
		codetrees[5].setNodeName("四川");
		// 成都 达州 拉萨 乐山 泸州 绵阳 内江 南充 西昌 宜宾
		String[] subNames05 = { "61000000", "63500000", "61400000", "64600000",
				"62100000", "64100000", "63700000", "61500000", "64400000","61002500" };
		codetrees[5].setSubNames(subNames05);
		codetrees[5].setCount(0);
		codetrees[5].setWeights(0);

		// ---------------------------------------
		// 省际路向。==西藏==
		codetrees[6] = new CodeTree();
		codetrees[6].setNodeName("西藏");
		// 拉萨
		String[] subNames06 = { "85000000" };
		codetrees[6].setSubNames(subNames06);
		codetrees[6].setCount(0);
		codetrees[6].setWeights(0);

		// ---------------------------------------
		// 省际路向。==重庆==
		codetrees[7] = new CodeTree();
		codetrees[7].setNodeName("重庆");
		// 重庆
		String[] subNames07 = { "40000000","40001800" };
		codetrees[7].setSubNames(subNames07);
		codetrees[7].setCount(0);
		codetrees[7].setWeights(0);

		// ---------------------------------------
		// 省际路向。==福建==
		codetrees[8] = new CodeTree();
		codetrees[8].setNodeName("福建");
		// 福州 龙岩 南平 泉州 三明 厦门 漳州 福清 莆田 厦门国际 福州国际
		String[] subNames08 = { "35000000", "36400000", "35300000", "36200000",
				"36500000", "36100000", "36300000", "35030000", "35110000","36104800","35004900" };
		codetrees[8].setSubNames(subNames08);
		codetrees[8].setCount(0);
		codetrees[8].setWeights(0);

		// ---------------------------------------
		// 省际路向。==云南==
		codetrees[9] = new CodeTree();
		codetrees[9].setNodeName("云南");
		// 昆明
		String[] subNames09 = { "65000000" };
		codetrees[9].setSubNames(subNames09);
		codetrees[9].setCount(0);
		codetrees[9].setWeights(0);

		// ---------------------------------------
		// 省际路向。==湖北==
		codetrees[10] = new CodeTree();
		codetrees[10].setNodeName("湖北");
		// 十堰 武汉 襄阳 宜昌 武汉国际
		String[] subNames10 = { "44200000", "43000000", "44100000", "44300000", "43032100"};
		codetrees[10].setSubNames(subNames10);
		codetrees[10].setCount(0);
		codetrees[10].setWeights(0);

		// ---------------------------------------
		// 省际路向。==河南==
		codetrees[11] = new CodeTree();
		codetrees[11].setNodeName("河南");
		// 安阳 洛阳 漯河 南阳 商丘 新乡 郑州 驻马店 信阳
		String[] subNames11 = { "45500000", "47100000", "46200000", "47300000",
				"47600000", "45300000", "45000000", "46300000", "46400000" };
		codetrees[11].setSubNames(subNames11);
		codetrees[11].setCount(0);
		codetrees[11].setWeights(0);

		// ---------------------------------------
		// 省际路向。==甘肃==
		codetrees[12] = new CodeTree();
		codetrees[12].setNodeName("甘肃");
		// 酒泉 兰州 天水
		String[] subNames12 = { "73500000", "73000000", "74100000" ,"73004400"};
		codetrees[12].setSubNames(subNames12);
		codetrees[12].setCount(0);
		codetrees[12].setWeights(0);

		// ---------------------------------------
		// 省际路向。==宁夏==
		codetrees[13] = new CodeTree();
		codetrees[13].setNodeName("宁夏");
		// 银川
		String[] subNames13 = { "75000000","75003800" };
		codetrees[13].setSubNames(subNames13);
		codetrees[13].setCount(0);
		codetrees[13].setWeights(0);

		// ---------------------------------------
		// 省际路向。==青海==
		codetrees[14] = new CodeTree();
		codetrees[14].setNodeName("青海");
		// 西宁
		String[] subNames14 = { "81000000" };
		codetrees[14].setSubNames(subNames14);
		codetrees[14].setCount(0);
		codetrees[14].setWeights(0);

		// ---------------------------------------
		// 省际路向。==新疆==
		codetrees[15] = new CodeTree();
		codetrees[15].setNodeName("新疆");
		// 喀什 库尔勒 乌市
		String[] subNames15 = { "84400000", "84100000", "83000000","83004400" };
		codetrees[15].setSubNames(subNames15);
		codetrees[15].setCount(0);
		codetrees[15].setWeights(0);

		// ---------------------------------------
		// 省际路向。==陕西==
		codetrees[16] = new CodeTree();
		codetrees[16].setNodeName("陕西");
		// 安康 宝鸡 西安 咸阳 延安 汉中
		String[] subNames16 = { "72500000", "72100000", "71000000", "71200000",
				"71600000", "72300000","71004200" };
		codetrees[16].setSubNames(subNames16);
		codetrees[16].setCount(0);
		codetrees[16].setWeights(0);

		// ---------------------------------------
		// 省际路向。==湖南==
		codetrees[17] = new CodeTree();
		codetrees[17].setNodeName("湖南");
		// 长沙 常德 郴州 衡阳 怀化 娄底 邵阳 湘潭 永州 岳阳 株洲 吉首
		String[] subNames17 = { "41000000", "41500000", "42300000", "42100000",
				"41800000", "41700000", "42200000", "41110000", "42500000",
				"41400000", "41200000", "41600000" };
		codetrees[17].setSubNames(subNames17);
		codetrees[17].setCount(0);
		codetrees[17].setWeights(0);

		// ---------------------------------------
		// 省际路向。==北京==
		codetrees[18] = new CodeTree();
		codetrees[18].setNodeName("北京");
		// 北京
		String[] subNames18 = { "10000000" };
		codetrees[18].setSubNames(subNames18);
		codetrees[18].setCount(0);
		codetrees[18].setWeights(0);

		// ---------------------------------------
		// 省际路向。==内蒙古==
		codetrees[19] = new CodeTree();
		codetrees[19].setNodeName("内蒙古");
		// 包头 赤峰 呼和浩特 通辽
		String[] subNames19 = { "01400000", "02400000", "01000000", "02800000" };
		codetrees[19].setSubNames(subNames19);
		codetrees[19].setCount(0);
		codetrees[19].setWeights(0);

		// ---------------------------------------
		// 省际路向。==辽宁==
		codetrees[20] = new CodeTree();
		codetrees[20].setNodeName("辽宁");
		// 抚顺 营口 沈阳 锦州 丹东 鞍山 大连 本溪 辽阳
		String[] subNames20 = { "11300000", "11500000", "11000000", "12100000",
				"11800000", "11400000", "11600000", "11700000", "11100000" };
		codetrees[20].setSubNames(subNames20);
		codetrees[20].setCount(0);
		codetrees[20].setWeights(0);

		// ---------------------------------------
		// 省际路向。==河北==
		codetrees[21] = new CodeTree();
		codetrees[21].setNodeName("河北");
		// 沧州 保定 承德 邯郸 衡水 廊坊 秦皇岛 石家庄 唐山 邢台 张家口
		String[] subNames21 = { "06100000", "07100000", "06700000", "05600000",
				"05300000", "06500000", "06600000", "05000000", "06300000",
				"05400000", "07500000" };
		codetrees[21].setSubNames(subNames21);
		codetrees[21].setCount(0);
		codetrees[21].setWeights(0);

		// ---------------------------------------
		// 省际路向。==山西==
		codetrees[22] = new CodeTree();
		codetrees[22].setNodeName("山西");
		// 长治 大同 侯马 太原
		String[] subNames22 = { "04600000", "03700000", "04300000", "03000000" };
		codetrees[22].setSubNames(subNames22);
		codetrees[22].setCount(0);
		codetrees[22].setWeights(0);

		// ---------------------------------------
		// 省际路向。==天津==
		codetrees[23] = new CodeTree();
		codetrees[23].setNodeName("天津");
		// 天津
		String[] subNames23 = { "30000000" };
		codetrees[23].setSubNames(subNames23);
		codetrees[23].setCount(0);
		codetrees[23].setWeights(0);

		// ---------------------------------------
		// 省际路向。==吉林==
		codetrees[24] = new CodeTree();
		codetrees[24].setNodeName("吉林");
		// 延吉 海拉尔 长春 吉林
		String[] subNames24 = { "13300000", "02100000", "13000000", "13200000" };
		codetrees[24].setSubNames(subNames24);
		codetrees[24].setCount(0);
		codetrees[24].setWeights(0);

		// ---------------------------------------
		// 省际路向。==黑龙江==
		codetrees[25] = new CodeTree();
		codetrees[25].setNodeName("黑龙江");
		// 哈尔滨 佳木斯 牡丹江 齐齐哈尔
		String[] subNames25 = { "15000000", "15400000", "15700000", "16100000" };
		codetrees[25].setSubNames(subNames25);
		codetrees[25].setCount(0);
		codetrees[25].setWeights(0);

		// ---------------------------------------
		// 省际路向。==江苏==
		codetrees[26] = new CodeTree();
		codetrees[26].setNodeName("江苏");
		// 南通 常州 阜阳 淮安 江阴 连云港 南京 苏州 泰州 无锡 徐州 盐城 扬州 镇江 楚州
		String[] subNames26 = { "22600000", "21300000", "23600000",
				"22300000", "21440000", "22200000", "21000000", "21500000",
				"22530000", "21400000", "22100000", "22400000", "22500000",
				"21200000", "22320000" };
		codetrees[26].setSubNames(subNames26);
		codetrees[26].setCount(0);
		codetrees[26].setWeights(0);

		// ---------------------------------------
		// 省际路向。==安徽== 
		codetrees[27] = new CodeTree();
		codetrees[27].setNodeName("安徽");
		// 合肥 安庆 蚌埠 黄山 宿州 芜湖 阜阳
		String[] subNames27 = { "23000000", "24600000", "23300000", "24500000",
				"23400000", "24100000","23600000" };
		codetrees[27].setSubNames(subNames27);
		codetrees[27].setCount(0);
		codetrees[27].setWeights(0);

		// ---------------------------------------
		// 省际路向。==浙江==
		codetrees[28] = new CodeTree();
		codetrees[28].setNodeName("浙江");
		// 绍兴 杭州 嘉兴 金华 宁波 衢州 台州 温州 湖州
		String[] subNames28 = { "31200000", "31000000", "31400000", "32100000",
				"31500000", "32400000", "31800000", "32500000","31300000" };
		codetrees[28].setSubNames(subNames28);
		codetrees[28].setCount(0);
		codetrees[28].setWeights(0);

		// ---------------------------------------
		// 省际路向。==上海==
		codetrees[29] = new CodeTree();
		codetrees[29].setNodeName("上海");
		// 上海
		String[] subNames29 = { "20000000" };
		codetrees[29].setSubNames(subNames29);
		codetrees[29].setCount(0);
		codetrees[29].setWeights(0);
		
		// ---------------------------------------
		// 省际路向。==三角中心==
		codetrees[30] = new CodeTree();
		codetrees[30].setNodeName("三角中心");
		// 上海
		String[] subNames30 = { "52840100" };
		codetrees[30].setSubNames(subNames30);
		codetrees[30].setCount(0);
		codetrees[30].setWeights(0);
		
		// ---------------------------------------
		// 省际路向。==未知==
		codetrees[31] = new CodeTree();
		codetrees[31].setNodeName("未知");
		// 上海
		String[] subNames31 = { "00000000" };
		codetrees[31].setSubNames(subNames31);
		codetrees[31].setCount(0);
		codetrees[31].setWeights(0);
		

		return codetrees;

	}

	/**
	 * 各经转关系机构代码，用于经济出口业务量报表匹配。
	 * 
	 * @author 唐东宇
	 * @return
	 */
	public CodeTree[] initCodeForProvider() {
		this.codetrees = new CodeTree[19];
		// ---------------------------------------
		// 省内路向。==广东==
		codetrees[0] = new CodeTree();
		codetrees[0].setNodeName("广东");
		//广州国际 深圳国际
		String[] subNames00 = { "52400000", "52500000", "52950000", "52730000",
				"52600000", "52900000", "52800000", "52820000", "52810000",
				"52830000", "51000000", "51140000", "52840000", "51150000",
				"51200000", "52300000", "51800000", "51600000", "51660000",
				"52100000", "52200000", "51530000", "51500000", "51400000",
				"51700000", "51160000", "51300000", "51900000" ,"51003100","51805300","51805000"};
		codetrees[0].setSubNames(subNames00);
		codetrees[0].setCount(0);
		codetrees[0].setWeights(0);
		// ---------------------------------------
		// 省际路向。==长沙==
		codetrees[1] = new CodeTree();
		codetrees[1].setNodeName("长沙");
		String[] subNames01 = { "51900000", "41000000", "41500000", "42300000",
				"42100000", "41800000", "41700000", "42200000", "41110000",
				"42500000", "41400000", "41200000", "41600000" };

		codetrees[1].setSubNames(subNames01);
		codetrees[1].setCount(0);
		codetrees[1].setWeights(0);
		// ---------------------------------------
		// 省际路向。==无锡==
		codetrees[2] = new CodeTree();
		codetrees[2].setNodeName("无锡");
		String[] subNames02 = { "24600000", "23300000", "21300000", "23600000",
				"23000000", "31300000", "22300000", "24500000", "21440000",
				"22200000", "21000000", "22600000", "20000000", "31200000",
				"21500000", "23400000", "22530000", "21400000", "24100000",
				"22100000", "22400000", "22500000", "21200000", "22320000" };

		codetrees[2].setSubNames(subNames02);
		codetrees[2].setCount(0);
		codetrees[2].setWeights(0);
		// ---------------------------------------
		// 省际路向。==杭州==
		codetrees[3] = new CodeTree();
		codetrees[3].setNodeName("杭州");
		String[] subNames03 = { "31000000", "31400000", "32100000", "31500000",
				"32400000", "31800000", "32500000" };

		codetrees[3].setSubNames(subNames03);
		codetrees[3].setCount(0);
		codetrees[3].setWeights(0);
		// ---------------------------------------
		// 省际路向。==成都==
		codetrees[4] = new CodeTree();
		codetrees[4].setNodeName("成都");
		String[] subNames04 = { "61000000", "63500000", "85000000", "61400000",
				"64600000", "62100000", "64100000", "63700000", "61500000",
				"64400000", "40000000","61002500","40001800" };

		codetrees[4].setSubNames(subNames04);
		codetrees[4].setCount(0);
		codetrees[4].setWeights(0);
		// ---------------------------------------
		// 省际路向。==济南==
		codetrees[5] = new CodeTree();
		codetrees[5].setNodeName("济南");
		// 德州 菏泽 济南 济宁 聊城 临沂 青岛 泰安 潍坊 薛城 烟台 枣庄 淄博 青岛国际 济南国际 烟台国际 威海国际
		String[] subNames05 = { "25300000", "27400000", "25000000", "27200000",
				"25200000", "27600000", "26600000", "27100000", "26100000",
				"27700000", "26400000", "27710000", "25500000" ,"26603700","25004300","26404200","26423800"};

		codetrees[5].setSubNames(subNames05);
		codetrees[5].setCount(0);
		codetrees[5].setWeights(0);
		// ---------------------------------------
		// 省际路向。==昆明==
		codetrees[6] = new CodeTree();
		codetrees[6].setNodeName("昆明");
		String[] subNames06 = { "65000000" };
		codetrees[6].setSubNames(subNames06);
		codetrees[6].setCount(0);
		codetrees[6].setWeights(0);
		// ---------------------------------------
		// 省际路向。==西安==
		codetrees[7] = new CodeTree();
		codetrees[7].setNodeName("西安");
		//西安国际 乌市国际 兰州国际 银川国际
		String[] subNames07 = { "72500000", "72100000", "72300000", "73500000",
				"84400000", "84100000", "73000000", "74100000", "83000000",
				"71000000", "81000000", "71200000", "71600000", "75000000","71004200" ,"83004400","73004400","75003800" };
		codetrees[7].setSubNames(subNames07);
		codetrees[7].setCount(0);
		codetrees[7].setWeights(0);
		// ---------------------------------------
		// 省际路向。==武汉==
		codetrees[8] = new CodeTree();
		codetrees[8].setNodeName("武汉");
		String[] subNames08 = { "44200000", "43000000", "44100000", "44300000", "43032100" };
		codetrees[8].setSubNames(subNames08);
		codetrees[8].setCount(0);
		codetrees[8].setWeights(0);
		// ---------------------------------------
		// 省际路向。==郑州==
		codetrees[9] = new CodeTree();
		codetrees[9].setNodeName("郑州");
		String[] subNames09 = { "45500000", "47100000", "46200000", "47300000",
				"47600000", "45300000", "45000000", "46300000", "46400000" };
		codetrees[9].setSubNames(subNames09);
		codetrees[9].setCount(0);
		codetrees[9].setWeights(0);
		// ---------------------------------------
		// 省际路向。==南昌==
		codetrees[10] = new CodeTree();
		codetrees[10].setNodeName("南昌");
		String[] subNames10 = { "34400000", "34100000", "34300000", "33300000",
				"33200000", "33000000", "33700000", "33400000", "33800000",
				"33600000", "33500000" };
		codetrees[10].setSubNames(subNames10);
		codetrees[10].setCount(0);
		codetrees[10].setWeights(0);
		// ---------------------------------------
		// 省际路向。==南宁==
		codetrees[11] = new CodeTree();
		codetrees[11].setNodeName("南宁");
		String[] subNames11 = { "54100000", "54500000", "53000000", "53700000",
				"54300000", "53500000" };
		codetrees[11].setSubNames(subNames11);
		codetrees[11].setCount(0);
		codetrees[11].setWeights(0);
		// ---------------------------------------
		// 省际路向。==贵阳==
		codetrees[12] = new CodeTree();
		codetrees[12].setNodeName("贵阳");
		// 贵阳 六盘水 遵义 贵阳国际
		String[] subNames12 = { "55000000", "55300000", "56300000","55004500" };
		codetrees[12].setSubNames(subNames12);
		codetrees[12].setCount(0);
		codetrees[12].setWeights(0);
		// ---------------------------------------
		// 省际路向。==福州==
		codetrees[13] = new CodeTree();
		codetrees[13].setNodeName("福州");
		
		String[] subNames13 = { "35000000", "36400000", "35300000", "36200000",
				"36500000", "36100000", "36300000", "35030000", "35110000","36104800","35004900" };
		codetrees[13].setSubNames(subNames13);
		codetrees[13].setCount(0);
		codetrees[13].setWeights(0);
		// ---------------------------------------
		// 省际路向。==海口==
		codetrees[14] = new CodeTree();
		codetrees[14].setNodeName("海口");
		String[] subNames14 = { "57000000" };
		codetrees[14].setSubNames(subNames14);
		codetrees[14].setCount(0);
		codetrees[14].setWeights(0);
		// ---------------------------------------
		// 省际路向。==棠溪1==
		codetrees[15] = new CodeTree();
		codetrees[15].setNodeName("棠溪1");
		String[] subNames15 = { "01400000", "07100000", "10000000", "06100000",
				"04600000", "06700000", "02400000", "03700000", "05600000",
				"05300000", "04300000", "01000000", "06500000", "06600000",
				"05000000", "03000000", "06300000", "30000000", "02800000",
				"05400000", "07500000", "11300000", "11500000", "11000000",
				"12100000", "11800000", "11400000", "11600000", "11700000",
				"11100000" };
		codetrees[15].setSubNames(subNames15);
		codetrees[15].setCount(0);
		codetrees[15].setWeights(0);
		// 省际路向。==棠溪2==
		codetrees[16] = new CodeTree();
		codetrees[16].setNodeName("棠溪2");
		String[] subNames16 = { "13000000", "15000000", "13200000", "15400000",
				"15700000", "16100000", "13300000", "02100000" };
		codetrees[16].setSubNames(subNames16);
		codetrees[16].setCount(0);
		codetrees[16].setWeights(0);
		// ---------------------------------------
		// 未知的事物，总是让人感到恐惧。
		codetrees[17] = new CodeTree();
		codetrees[17].setNodeName("中山三角");
		String[] subNames17 = {"52840100"};
		codetrees[17].setSubNames(subNames17);
		codetrees[17].setCount(0);
		codetrees[17].setWeights(0);
		// ---------------------------------------
		// 未知的事物，总是让人感到恐惧。
		codetrees[18] = new CodeTree();
		codetrees[18].setNodeName("其他未知");
		String[] subNames18 = null;
		codetrees[18].setSubNames(subNames18);
		codetrees[18].setCount(0);
		codetrees[18].setWeights(0);

		// 测试打印初始化内容
		/*for (int i = 0; i < codetrees.length; i++) {
			System.out.println(codetrees[i].toString());
		}*/

		return codetrees;

	}

	public static void main(String[] args) {
		CodeInit codeInit = new CodeInit();
		codeInit.initCodeForProvider();
	}

}
