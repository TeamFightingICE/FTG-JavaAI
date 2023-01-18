package loader;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

import aiinterface.AIInterface;

public class ResourceLoader {

	private ResourceLoader() {
		Logger.getAnonymousLogger().log(Level.INFO, "Create instance: " + ResourceLoader.class.getName());
	}
	/**
	 * ResourceLoaderクラスの唯一のインスタンスを取得する．
	 *
	 * @return ResourceLoaderクラスの唯一のインスタンス
	 */
	public static ResourceLoader getInstance() {
		return ResourceLoaderHolder.instance;
	}

	/**
	 * getInstance()が呼ばれたときに初めてインスタンスを生成するホルダークラス．
	 */
	private static class ResourceLoaderHolder {
		private static final ResourceLoader instance = new ResourceLoader();
	}
	
	public AIInterface loadAI(String aiName) {
		File file = new File("./data/ai/" + aiName + ".jar");

		try {
			ClassLoader cl = URLClassLoader.newInstance(new URL[] { file.toURI().toURL() });
			Class<?> c = cl.loadClass(aiName);
			AIInterface ai = (AIInterface) c.getDeclaredConstructor().newInstance();
			return ai;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
