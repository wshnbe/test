//package com.wll.code;
//import java.io.IOException;
//import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.concurrent.atomic.AtomicBoolean;
//
//import org.elasticsearch.action.bulk.*;
//import org.elasticsearch.client.transport.TransportClient;
//
///**
// * Created by xxx on 2016/08/30.
// */
//public class FileToEsOrderTest {
//
//    static ConcurrentLinkedQueue<String> queues = new ConcurrentLinkedQueue<String>();
//    static AtomicBoolean isInsert = new AtomicBoolean(true);
//    static TransportClient client = null;
//
//    public static void main(String[] agrs) throws Exception {
//        Settings settings = Settings.settingsBuilder()
//                .put("cluster.name", "elasticsearch-cluster").build();
//        client = TransportClient.builder().settings(settings).build();
//
//        try {
//            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("xxxxx"), 9500));
//        } catch (UnknownHostException error) {
//            System.out.print(error.getMessage());
//        }
//        final long aa = System.currentTimeMillis();
//
//        final ConcurrentHashMap<String, Boolean> hashMap = new ConcurrentHashMap();
//        for (int i = 0; i < 20; i++) {
//            new Thread(new Runnable() {
//                Integer num  = 1;
//                public void run() {
//                    //Add transport addresses and do something with the client...
//                    hashMap.put(Thread.currentThread().getName(), Boolean.FALSE);
//                    final BulkProcessor bulkProcessor = BulkProcessor.builder(client,
//                            new BulkProcessor.Listener() {
//                                //批量成功后执行
//                                public void afterBulk(long l, BulkRequest bulkRequest, BulkResponse bulkResponse) {
//                                      System.out.println("请求数量是:" + bulkRequest.numberOfActions());
//                                    if (bulkResponse.hasFailures()) {
//                                        for (BulkItemResponse item :  bulkResponse.getItems()) {
//                                            if (item.isFailed()) {
//                                                System.out.println("失败信息:--------" + 
//                                                item.getFailureMessage());
//                                            }
//                                        }
//                                    }
//                                }
//
//                                //批量提交之前执行
//                                public void beforeBulk(long executionId,BulkRequest request) {
//                                	
//                                }
//
//                                //批量失败后执行
//                                public void afterBulk(long executionId, BulkRequest request,Throwable failure) {
//                                    System.out.println("happen fail = " + failure.getMessage() + "cause = " + failure.getCause());
//                                }
//                            })
//                            .setBulkActions(10000)
//                            .setBulkSize(new ByteSizeValue(100, ByteSizeUnit.MB))
//                            .setBackoffPolicy(
//                                    BackoffPolicy.exponentialBackoff(
//                                            TimeValue.timeValueMillis(100), 3))
//                            .setConcurrentRequests(1)
//                            .build();
//                    while (true) {
//                        if (!queues.isEmpty()) {
//                            try {
//                                String json = queues.poll();
//                                if (json == null) continue;
//                                int index1 = json.indexOf("checksum");
//                                int index2 = json.indexOf("}", index1);
//                                index1 += 10;
//                                String id = json.substring(index1 + 1, index2 - 1);
//
//                                int index3 = json.indexOf("dp_id");
//                                int index4 = json.indexOf(",", index3);
//                                index3 += 7;
//                                String routing = json.substring(index3 + 1, index4 - 1);
//                                count++;
//                                bulkProcessor.add(new IndexRequest("xxxx", "xxxxx").id(id).routing(routing).source(json));
//                            } catch (Exception e) {
//                                System.out.print(e.getMessage());
//                            }
//                        }
//                        if (queues.isEmpty() && !isInsert.get()) {
//                            bulkProcessor.flush();
//                            long jjj = System.currentTimeMillis() - aa;
//                            System.out.print("   " + Thread.currentThread().getName()
//                                         + ":" + jjj + "   ");
//                            hashMap.put(Thread.currentThread().getName(), Boolean.TRUE);
//                            while (hashMap.values().contains(Boolean.FALSE)) {
//                                try {
//                                    Thread.currentThread().sleep(1 * 1000);
//                                } catch (Exception e) {
//                                    e.printStackTrace(System.out);
//                                }
//                            }
//                            bulkProcessor.close();
//                            break;
//                        }
//                    }
//                }
//            }).start();
//        }
//
//
////        File file = new File("/test/rfm/rfm_data.txt");
////        FileOutputStream fileOutputStream = new FileOutputStream((file));
////        OutputStreamWriter outputStreamWriter = 
////                      new OutputStreamWriter(fileOutputStream);
////        bufferedWriter = new BufferedWriter(outputStreamWriter);
//        for(int i = 2; i <= 23; i++){
//            WriteData("xxx" + i);
//        }
////        WriteData("rfm_1");
////        bufferedWriter.close();
////        outputStreamWriter.close();
////        fileOutputStream.close();
//        System.out.println("数据写入完毕");
//    }
//
//    // 写数据
//    public static void WriteData(String tableName) throws IOException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Integer count = 1;
//        List<String> columnName = Arrays.asList("trade_last_interval","trade_first_interval");
//        List<String> columnDateName = Arrays.asList("modify","trade_first_time","trade_last_time");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://xxxxxxxxx";
//            conn = DriverManager.getConnection(url, "xxxx", "xxxx");
//            System.out.println("写入数据开始，成功连接MySQL：" + tableName);
//
//            String sql = "select * from " + tableName;
//            ps = conn.prepareStatement(sql,
//                    ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//            ps.setFetchSize(Integer.MIN_VALUE);
//            rs = ps.executeQuery();
//
//            ResultSetMetaData rsmd = rs.getMetaData();
//            int colCount = rsmd.getColumnCount();
//            ObjectMapper objectMapper = new ObjectMapper()
//                    .setSerializationInclusion(JsonInclude.Include.NON_NULL)
//                    .setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
//                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
//                    .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
//                    .setPropertyNamingStrategy(
//                    PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
//
//            while(rs.next())  {  //while控制行数
//                Map<String, String> map = new LinkedHashMap<>();
//                 //StringBuilder buffer = new StringBuilder();
//                for(int i = 1; i <= colCount; i++  )   {
//                    String name = rsmd.getColumnName(i);
//                    if(!columnName.contains(name)) {
//                        String value = rs.getString(i);
//                        boolean flag = true;
//                        if(columnDateName.contains(name)){
//                            try {
//                                dateFormat.parse(value);
//                            } catch (Exception e){
//                                flag = false;
//                            }
//                        } else if("buyer_nick".equalsIgnoreCase(name)){
//                            value = encrypt(value);
//                        }
//                        if (flag && value != null && !"".equals(value.trim()) && value.trim().length() > 0) {
//                        //buffer.append("\"" + name + "\":\"" + value + "\"");
//                        //buffer.append(",");
//                            map.put(name, value);
//                        }
//                    }
//                }
//                count++;
//
//                if(map != null && map.size() > 0){
//                    queues.add(objectMapper.writeValueAsString(map));
//                }
//
//                if(count % 200000 == 0){
//                    int number = queues.size();
//                    int jj = number/200000;
//                    System.out.println("index: " + count + ", 
//                                        jj: " + jj + ", number: " + number);
//                    while(jj > 0){
//                        try {
//                            Thread.sleep(2000*jj);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        int number2 = queues.size();
//                        jj = number2 / 200000;
//                        System.out.println("index2: " + count + ",
//                                         jj: " + jj + ", number2: " + number2);
//                    }
//                }
//            }
//            isInsert = new AtomicBoolean(false);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                if(ps != null) {
//                    ps.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                if(conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(tableName + "数据写入完毕,共有数据：" + count);
//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}