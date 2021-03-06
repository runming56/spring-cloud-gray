package cn.springcloud.gray.decision.factory;

import cn.springcloud.gray.decision.GrayDecision;
import cn.springcloud.gray.decision.compare.Comparators;
import cn.springcloud.gray.decision.compare.PredicateComparator;
import cn.springcloud.gray.request.GrayHttpTrackInfo;
import lombok.Getter;
import lombok.Setter;

public class TrackAttributeGrayDecisionFactory extends CompareGrayDecisionFactory<TrackAttributeGrayDecisionFactory.Config> {

    public TrackAttributeGrayDecisionFactory() {
        super(TrackAttributeGrayDecisionFactory.Config.class);
    }


    @Override
    public GrayDecision apply(Config configBean) {
        return args -> {
            GrayHttpTrackInfo grayTrackInfo = (GrayHttpTrackInfo) args.getGrayRequest().getGrayTrackInfo();
            if (grayTrackInfo == null) {
                return false;
            }
            PredicateComparator<String> predicateComparator = Comparators.getStringComparator(configBean.getCompareMode());
            if (predicateComparator == null) {
                return false;
            }
            return predicateComparator.test(grayTrackInfo.getAttribute(configBean.getName()), configBean.getValue());
        };
    }

    @Setter
    @Getter
    public static class Config extends CompareGrayDecisionFactory.CompareConfig {
        private String name;
        private String value;

    }

}
