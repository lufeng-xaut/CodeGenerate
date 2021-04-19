/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.utils;

import java.math.BigDecimal;

/**
 * 类的功能描述
 *
 * @author lufeng
 */
public class FantCurrencyUtils {
    private static final String[] CN_UPPER_NUMBER = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] CN_UPPER_MONETRAY_UNIT = new String[]{"分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾", "佰", "仟"};
    private static final String CN_FULL = "整";
    private static final String CN_NEGATIVE = "负";
    private static final int MONEY_PRECISION = 2;
    private static final String CN_ZEOR_FULL = "零元整";

    public FantCurrencyUtils() {
    }

    public static String convertToCapitalAmount(BigDecimal numberOfMoney) {
        if (numberOfMoney == null) {
            return null;
        } else {
            StringBuffer sb = new StringBuffer();
            int signum = numberOfMoney.signum();
            if (signum == 0) {
                return "零元整";
            } else {
                long number = numberOfMoney.movePointRight(2).setScale(0, 4).abs().longValue();
                long scale = number % 100L;
                int numIndex = 0;
                boolean getZero = false;
                if (scale <= 0L) {
                    numIndex = 2;
                    number /= 100L;
                    getZero = true;
                }

                if (scale > 0L && scale % 10L <= 0L) {
                    numIndex = 1;
                    number /= 10L;
                    getZero = true;
                }

                for(int zeroSize = 0; number > 0L; ++numIndex) {
                    int numUnit = (int)(number % 10L);
                    if (numUnit > 0) {
                        if (numIndex == 9 && zeroSize >= 3) {
                            sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                        }

                        if (numIndex == 13 && zeroSize >= 3) {
                            sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                        }

                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                        sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                        getZero = false;
                        zeroSize = 0;
                    } else {
                        ++zeroSize;
                        if (!getZero) {
                            sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                        }

                        if (numIndex == 2) {
                            if (number > 0L) {
                                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                            }
                        } else if ((numIndex - 2) % 4 == 0 && number % 1000L > 0L) {
                            sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                        }

                        getZero = true;
                    }

                    number /= 10L;
                }

                if (signum == -1) {
                    sb.insert(0, "负");
                }

                if (scale <= 0L) {
                    sb.append("整");
                }

                return sb.toString();
            }
        }
    }
}
