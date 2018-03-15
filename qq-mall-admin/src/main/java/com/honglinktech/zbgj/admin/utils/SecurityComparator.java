package com.honglinktech.zbgj.admin.utils;

import java.io.Serializable;
import java.util.Comparator;
import com.honglinktech.zbgj.entity.Security;

/**
 * Created by Dayong on 16/3/22.
 */
public class SecurityComparator implements Serializable, Comparator<Security> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public int compare(Security o1, Security o2) {
        if (o1.getParentId() > o2.getParentId()) {
            return 1;
        } else if (o1.getParentId() == o2.getParentId()) {
            return 0;
        } else {
            return -1;
        }
    }
}
