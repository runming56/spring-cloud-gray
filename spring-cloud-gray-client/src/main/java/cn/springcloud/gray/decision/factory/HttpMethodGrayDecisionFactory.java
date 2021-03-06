package cn.springcloud.gray.decision.factory;

import cn.springcloud.gray.decision.GrayDecision;
import cn.springcloud.gray.decision.compare.Comparators;
import cn.springcloud.gray.decision.compare.PredicateComparator;
import cn.springcloud.gray.request.GrayHttpRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;

public class HttpMethodGrayDecisionFactory extends AbstractGrayDecisionFactory<HttpMethodGrayDecisionFactory.Config> {


    public HttpMethodGrayDecisionFactory() {
        super(Config.class);
    }

    @Override
    public GrayDecision apply(Config configBean) {
        return args -> {
            GrayHttpRequest grayRequest = (GrayHttpRequest) args.getGrayRequest();
            PredicateComparator<String> predicateComparator = Comparators.getStringComparator(configBean.getCompareMode());
            if (predicateComparator == null) {
                return false;
            }
            return predicateComparator.test(grayRequest.getMethod(), configBean.getMethod().name());
        };
    }


    @Setter
    @Getter
    public static class Config extends CompareGrayDecisionFactory.CompareConfig {
        private HttpMethod method;

    }
}
