# Billing rules 

This document is translated by a translation tool.       

The resources are charged according to the unit price and usage, and the bills are generated in each settlement cycle, and the fees are automatically deducted from the account.The settlement period shall be settled once a day. Within the settlement period, the fees shall be calculated according to the actual usage of resources. If there is less than one billing unit, the fees shall be calculated according to one billing unit.

For example, if you subscribe to a RabbitMQ service on January 2nd, use up the 300W message limit in the base package on January 5th, and then continue to use it, the relevant billing rules are as follows:

* From 00:00:00 to 23:59:59 on January 5, RabbitMQ Payg usage amount is 8W, 8W / 10W =0.8 units, less than one unit is calculated as one unit, the cost is 1 unit *0.3 WP/unit =0.3 WP, and the unused 2W amount will be postponed to the next day.
* From 00:00:00 to 23:59:59 on January 6, the RabbitMQ Payg usage amount is 1W. If the 2W quota postponed in the previous day is not used up, there will be no bill and no deduction. The 1W RabbitMQ Payg usage amount will be postponed to the next day.。
* From 00:00:00 to 23:59:59 on January 7th, the RabbitMQ Payg usage amount is 13W. After the 1W of the previous day is used, 13W-1W = 12W, 12W / 10W =1.2 units, the daily fee is 2 units *0.3 WP/unit =0.6 WP, and the 8W of the unused RabbitMQ Payg is postponed to the next day.
* By analogy, the unused amount can only be used in the current month, and cannot be postponed to the next month.

| 结算周期                       | 产生费用                                                     | Notes                                                    |
| ------------------------------ | ------------------------------------------------------------ | -------------------------------------------------------- |
| January 5 00:00:00 ~ 23:59:59  | RabbitMQ Payg usage amount is 8W, 8W / 10W =0.8 units, less than one unit is calculated as one unit, the cost is 1 unit *0.3 WP/unit =0.3 WP. | The unused 2W quota will be extended to the next day     |
| January 6 00:00:00 ~ 23:59:59  | If the 2W quota extended in the previous day is not used up, there will be no bill and no deduction | The unused 1W quota will be extended to the next day     |
| January 7 00:00:00 ~ 23:59:59  | The RabbitMQ Payg usage amount is 13W. After the 1W extended in the previous day is used, the new RabbitMQ usage amount is 13W-1W = 12W, 12W / 10W =1.2 units, and the daily cost is 2 units *0.3 WP/unit =0.6 WP | The unused 8W quota will be extended to the next day     |
| ......                         | ......                                                       | ......                                                   |
| January 31 00:00:00 ~ 23:59:59 | RabbitMQ Payg usage amount is 6W. After using 1W of the previous day, 6W-1W = 5W, 5W / 10W =0.2 units. If one unit is less than one, the daily cost is 1 unit *0.3 WP/unit =0.3 WP | The unused 5W items cannot be deferred to the next month |

