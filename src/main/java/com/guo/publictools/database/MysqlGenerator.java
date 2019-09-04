package com.guo.publictools.database;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ProjectName: publictools
 * @Package: com.guo.publictools.database
 * @ClassName: MysqlGenerator
 * @Author: Guo Hongliang
 * @Description: MyBatis-plus代码生成类
 * @Date: 9/3/2019 10:14 AM
 * @Version: 1.0
 */
public class MysqlGenerator {

    /**
     * 生成类输出文件夹
     */
    public static final String OUTPUT_DIR = "C:/work/Project/Temp/";

    /**
     * 生成java文件输出目录
     */
    public static final String JAVA_FILE_OUTPUT_DIR= "src/main/java";

    /**
     * 生成mapper的xml文件输出目录
     */
    public static final String XML_FILE_OUTPUT_DIR= "src/main/resources/mapper/";

    /**
     * 开发者名字
     */
    public static final String DEVELOPER_AUTHOR = "Guo Hongliang";

    /**
     * Java Bean实体类名字
     */
    public static final String ENTITY_NAME = "%sObj";

    /**
     *  mapper的XML文件名字
     */
    public static final String XML_NAME = "%sMapper";

    /**
     * dao接口的文件名字
     */
    public static final String MAPPER_NAME = "%sDao";

    /**
     * 链接数据库url
     */
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ppms?useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";

    /**
     * 链接数据库驱动包
     */
    public static final String DATABASE_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    /**
     * 链接数据库用户名
     */
    public static final String DATABASE_USER_NAME = "root";

    /**
     * 链接数据库用户密码
     */
    public static final String DATABASE_USER_PWD = "123456";

    /**
     * 业务模块名称
     */
    public static final String MODULE_NAME = "";

    /**
     * 工程的包名
     */
    public static final String PACKAGE_NAME = "com.bba.xxx";

    /**
     * xml模板文件名
     */
    public static final String XML_TEMPLATE_NAME = "template/mapper.xml";
    /**
     * 实体类模板文件名
     */
    public static final String ENTITY_TEMPLATE_NAME = "template/entity.java";
    /**
     * mapper模板文件名
     */
    public static final String MAPPER_TEMPLATE_NAME = "template/mapper.java";
    /**
     * service接口模板文件名
     */
    public static final String SERVICE_TEMPLATE_NAME = "template/service.java";
    /**
     * service接口实现类模板文件名
     */
    public static final String SERVICE_IMPL_TEMPLATE_NAME = "template/serviceImpl.java";
    /**
     * controller模板文件名
     */
    public static final String CONTROLLER_TEMPLATE_NAME = "template/controller.java";





    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        // 实例化代码生成器类
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // String projectPath = System.getProperty("user.dir");
        // 设置输出文件夹
        // globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setOutputDir(OUTPUT_DIR + JAVA_FILE_OUTPUT_DIR);
        // 设置代码开发作者
        globalConfig.setAuthor(DEVELOPER_AUTHOR);
        // 生成后是否打开window资源管理器
        globalConfig.setOpen(true);
        // 实体属性 Swagger2 注解
        globalConfig.setSwagger2(true);
        // 是否开启mapper文件中的resultMap
        globalConfig.setBaseResultMap(true);
        // 是否开启mapper文件中的columnList
        globalConfig.setBaseColumnList(true);
        // 时间类型对应策略
        globalConfig.setDateType(DateType.ONLY_DATE);

        // java bean实体类的名字
        globalConfig.setEntityName(ENTITY_NAME);
        // mapper文件名字，用默认的即可
        globalConfig.setXmlName(XML_NAME);
        // dao接口文件名字
        globalConfig.setMapperName(MAPPER_NAME);
        // service接口文件名字，用默认的即可
        // globalConfig.setServiceName("");
        // service实现类名字，用默认的即可
        // globalConfig.setServiceImplName("");
        // controller文件名字，用默认的即可
        // globalConfig.setControllerName("");

        autoGenerator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(DATABASE_URL);
        // 数据库 schema name，例如 PostgreSQL 可指定为 public
        // dataSourceConfig.setSchemaName("public");
        dataSourceConfig.setDriverName(DATABASE_DRIVER_NAME);
        dataSourceConfig.setUsername(DATABASE_USER_NAME);
        dataSourceConfig.setPassword(DATABASE_USER_PWD);
        autoGenerator.setDataSource(dataSourceConfig);

        // 数据表配置
        StrategyConfig strategyConfig = new StrategyConfig();
        // 是否大写命名
        strategyConfig.setCapitalMode(true);
        // 是否跳过视图
        strategyConfig.setSkipView(true);
        // 数据库表映射到实体的命名策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 数据库表前缀
        // strategyConfig.setTablePrefix();
        // 数据库表的字段前缀
        // strategyConfig.setFieldPrefix();
        // 自定义继承的Entity类全称，带包名
        // strategyConfig.setSuperEntityClass();
        // 自定义基础的Entity类，公共字段
        // strategyConfig.setSuperEntityColumns("a", "b", "c");
        // 自定义继承的Mapper类全称，带包名
        // strategyConfig.setSuperMapperClass();
        // 自定义继承的Service类全称，带包名
        // strategyConfig.setSuperServiceClass();
        // 自定义继承的ServiceImpl类全称，带包名
        // strategyConfig.setSuperServiceImplClass();
        // 自定义继承的Controller类全称，带包名
        // strategyConfig.setSuperControllerClass();
        // 需要包含的表名，允许正则表达式（与exclude二选一配置）
        // strategyConfig.setInclude();
        // 需要排除的表名，允许正则表达式
        // strategyConfig.setExclude();
        // 【实体】是否生成字段常量（默认 false）
        // strategyConfig.setEntityColumnConstant();
        // 【实体】是否为构建者模型（默认 false）
        // strategyConfig.setEntityBuilderModel();
        // 【实体】是否为lombok模型（默认 false）
        strategyConfig.setEntityLombokModel(true);
        // Boolean类型字段是否移除is前缀（默认 false）
        // strategyConfig.setEntityBooleanColumnRemoveIsPrefix();
        // 生成@RestController 控制器
        strategyConfig.setRestControllerStyle(true);
        // 驼峰转连字符？？
        // strategyConfig.setControllerMappingHyphenStyle(false);
        // 是否生成实体时，生成字段注解
        // strategyConfig.setEntityTableFieldAnnotationEnable(true);
        // 逻辑删除属性名称
        // strategyConfig.setLogicDeleteFieldName();
        // 表填充字段
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<TableFill>();
        // 如 每张表都有一个创建时间、修改时间
        // 而且这基本上就是通用的了，新增时，创建时间和修改时间同时修改
        // 修改时，修改时间会修改，
        // 虽然像Mysql数据库有自动更新机制，但像ORACLE的数据库就没有了，
        // 使用公共字段填充功能，就可以实现，自动按场景更新了。
        // 如下是配置
        TableFill createField = new TableFill("create_time", FieldFill.INSERT);
        TableFill modifiedField = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        tableFillList.add(createField);
        tableFillList.add(modifiedField);
        strategyConfig.setTableFillList(tableFillList);
        autoGenerator.setStrategy(strategyConfig);


        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        // 业务模块名称
        packageConfig.setModuleName(MODULE_NAME);
        // 项目的包名称
        packageConfig.setParent(PACKAGE_NAME);
        // 项目的实体类包名
        // packageConfig.setEntity();
        // 项目的service接口包名
        // packageConfig.setService();
        // 项目的service实现类包名
        // packageConfig.setServiceImpl();
        // 项目的mapper包名
        // packageConfig.setMapper();
        // 项目的mapper的xml包名
        // packageConfig.setXml();
        // 项目的controller包名
        // packageConfig.setController();

        autoGenerator.setPackageInfo(packageConfig);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 如果使用非默认的模板(非velocity),则要单独声明
        // set freemarker engine
        // generator.setTemplateEngine(new FreemarkerTemplateEngine());
        // set beetl engine
        // generator.setTemplateEngine(new BeetlTemplateEngine());
        // set custom engine (reference class is your custom engine class)
        // generator.setTemplateEngine(new CustomTemplateEngine());
        // other config...

        // 配置自定义输出模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // Java 实体类模板
        templateConfig.setEntity(ENTITY_TEMPLATE_NAME);
        // Service接口模板
        templateConfig.setService(SERVICE_TEMPLATE_NAME);
        // Service接口实现类模板
        templateConfig.setServiceImpl(SERVICE_IMPL_TEMPLATE_NAME);
        // mapper 模板
        templateConfig.setMapper(MAPPER_TEMPLATE_NAME);
        // mapper xml 模板(因为后面有自定义设置)
        templateConfig.setXml(null);
        // controller 控制器模板
        templateConfig.setController(CONTROLLER_TEMPLATE_NAME);

        autoGenerator.setTemplate(templateConfig);


        // 自定义配置,改变mapper的XML文件的输出位置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(XML_TEMPLATE_NAME + ".vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return OUTPUT_DIR + XML_FILE_OUTPUT_DIR + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
//
////        cfg.setFileCreate(new IFileCreate() {
////            @Override
////            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
////                // 判断自定义文件夹是否需要创建
////                checkDir("调用默认方法创建的目录");
////                return false;
////            }
////        });
//
        injectionConfig.setFileOutConfigList(focList);
        autoGenerator.setCfg(injectionConfig);

        autoGenerator.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
