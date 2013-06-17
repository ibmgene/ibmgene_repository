package cn.ibm.com.web.generation;


import cn.ibm.com.web.generation.stock.StockMainGenerator;


public class GenerateMainTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*GenerationThreadManager manager = (GenerationThreadManager) BeanLocator.getBean("generationThreadManager");
		manager.generateStock();
		*/
		long start = System.currentTimeMillis();

		StockMainGenerator stockMainGenerator = (StockMainGenerator) BeanLocator.getBean("stockMainGenerator");
		stockMainGenerator.generateMain("002550");

		System.out.println(System.currentTimeMillis() - start);
		System.exit(0);

	}

}
