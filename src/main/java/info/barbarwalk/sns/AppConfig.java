package info.barbarwalk.sns;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import info.barbarwalk.sns.core.AppIntercepter;

/**
 * アプリケーション設定クラス。
 *
 * @author barbar-walk
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

	/** 登録したいインターセプター。リクエストの前後を中継する。 */
	@Autowired
	private AppIntercepter<?> appInterceptor;

	/** インターセプターで含めるpathパターン。 */
	private static final String[] INCLUDE_PATTERNS = { "/**" };

	/** インターセプターで除外するpathパターン。（※静的コンテンツを含めると、ログが出すぎてしまう為除外。） */
	private static final String[] EXCLUDE_PATTERNS = { "/assets/**" };

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		argumentResolvers.add(resolver);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// インターセプターの登録。
		registry.addInterceptor(appInterceptor)
				.addPathPatterns(INCLUDE_PATTERNS)
				.excludePathPatterns(EXCLUDE_PATTERNS);
	}
}
