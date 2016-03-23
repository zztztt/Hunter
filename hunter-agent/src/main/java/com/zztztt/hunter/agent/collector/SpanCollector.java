package com.zztztt.hunter.agent.collector;

import com.zztztt.hunter.common.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public final class SpanCollector extends AbstractCollector<Span>{
    private final static Logger logger = LoggerFactory.getLogger(SpanCollector.class);
    public final static int MAX_INTERVAL = 8 * 1024;
    public final static int MIN_INTERVAL = 2;

    public SpanCollector() {
        super(SpanCollector.class.getSimpleName());
        setInterval(MIN_INTERVAL);
        start();
    }

    /**
     * 上报逻辑, 根据每次上报队列中取出的数据大小, 动态变更上报的周期
     *
     * @param spans 上传列表
     * @return 上报是否success
     */
    @Override
    protected boolean upload(List<Span> spans) {
        boolean status = true;
        if (!spans.isEmpty()) {
            // TODO 上报log的逻辑
            logger.info(spans.toString());
        }
        int uploadSize = spans.size();
        if (uploadSize >= UPLOAD_SIZE && interval > MIN_INTERVAL) {
            interval = interval / 2;
        } else if (uploadSize < UPLOAD_SIZE && interval < MAX_INTERVAL) {
            interval = interval * 2;
        }
        return status;
    }
}
