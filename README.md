# tydeus-monitor 一种为监控而生的日志解决方案【4.30-V1】 

## 一、监控是什么？

"监控"多种多样，网上一搜，花样百出，每个公司都会有自己的监控系统，大部分的功能都为**监视+报警系统**，很少有业务控制和系统控制的相关功能
监控范围我个人理解分为几大类型
* 资源【CPU、内存】使用率等
* 系统监控【系统波动异常】
* 排查监控 【开发排查工具】
* 网络安全监控【黑客攻击】
* 视频监控 【家用 开个玩笑】

本文所讲监控为业务系统相关监控

## 一、监控目的是什么？
个人理解，其目的通常无外乎下面三点：
* 查看系统状况：如 进线量、完结率指标等
* 查看系统是否健康、运行是否良好？
* 查看系统是否存在异常，作为后续是否需要介入进而恢复正常的依据
2、监控需要做什么
假设你现在需要去判断一个业务系统是否运行良好，你需要做什么？

（1）首先，怎么才算是“运行良好”？判断依据是什么？
如果是开发同学，通常可能会去看CPU、内存、网络等资源利用率情况，以及HSF、MetaQ等中间件的QPS、RT、线程池等技术指标

如果是业务/运营/产品同学，他可能会去看诸如进线量、case完结率、卡片点击量等业务指标
