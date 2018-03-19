package management.controller;


//
public class UserController {
//
//
//    @Autowired
//    UserService userService;
//
//
//    @Autowired
//    CourseServiceInt courseService;
//
//    @Autowired
//    AddingTrainer addingTrainer;
//    @Autowired
//    AddingCourseInt addingCourse;
//
//    @GetMapping("/id")
//    public Integer geting() {
//        return 1;
//    }
//
//    @PostMapping("/login")
//    public boolean login(@RequestBody AllUsers user) {
//
//        return userService.login(user);
//
//
//    }
//
//
//    @GetMapping("/Trainers")
//    public Map<String, Trainer> GetTrainers() {
//        return addingTrainer.getTrainers();
//    }
//
//
//    @GetMapping("/gettingCources")
//    public Map<String, Course> course() {
//        return addingCourse.li();
//    }
//
//
//    @GetMapping("/gettingTrainer/{name}")
//    public Trainer gettingTrainer(@PathVariable("name") String name) {
//        Trainer trainer = addingTrainer.gettingTrainer(name);
//        return trainer;
//    }
//
//    @PostMapping("/trainer")
//    public Integer addingTrainer(@RequestBody Trainer trainer) {
//
//        return addingTrainer.addingTrainer(trainer);
//    }
//
//
//    @PostMapping("/user")
//    public ResponseEntity save(@RequestBody AllUsers user) {
//
//
//        int id = userService.save(user);
//        System.out.println("rrrr");
//        return ResponseEntity.ok().body("new user created with id" + id);
//
//    }
//
//    @PostMapping("/proposeCourse")
//    public Integer ProposeCourse(@RequestBody Course course) {
//
//        return courseService.proposeCourse(course);
//    }
//
//    @PostMapping("/addingCourse")
//    public Integer AddingCourse(@RequestBody Course course) {
//        return addingCourse.addCourse(course);
//    }
//
//    @GetMapping("/allProposedCourses")
//    public Map<String, Course> allProposedCourses() {
//        return courseService.gettingProposedCources();
//    }
//
//    @DeleteMapping("admin/suggestedcourses/delete/{name}/{id}")
//    public String deletedSuggestedCources(@PathVariable("name") String name, @PathVariable("id") int id) {
//        return courseService.deletedSuggestedCources(id, name);
//    }
//
//
//    @GetMapping("trainerid/getCources/{name}")
//    public List<String> listOfCources(@PathVariable("name") String name) {
//
//
//        Trainer trainer = addingTrainer.gettingTrainer(name);
//
//        List<String> cource = addingTrainer.listOfcources(trainer);
//
//        return cource;
//    }
//
//
//    @PostMapping("/trainerid/addinterval/")
//    public double[] AddIntervals(@RequestBody Course course) {
//
//        double[] eq = addingTrainer.addingSuggestedCourseInterval(course);
//        return eq;
//    }
//
//
//    @DeleteMapping("/trainerid/deleteinterval/{name}")
//    public double[] deleteInterval(@PathVariable("name") String name) {
//
//
//        return addingTrainer.deletionOfInterval(name);
//
//
//    }
//
//
//    @PostMapping("/courseid/choose/{name}")
//    public List<Course> choosingTime(@PathVariable("name") String name, @RequestBody Course course) throws Exception {
//
//
//        return userService.choosingTime(name, course);
//
//
//    }
//
//    @GetMapping("/courseid/datestimes/{courseid}")
//
//    public CourseDateAndTimesResponse courseDateAndTimesResponse(@PathVariable("courseid") Integer courseid) throws Exception {
//
//
//        CourseDateAndTimesResponse courseDateAndTimesResponse = addingCourse.gettingFreeTimesandDuration(courseid);
//
//
//
//
//        return courseDateAndTimesResponse;
//
//    }
////
/////courseid/choose – запись на курс на конкретное время
////    Body: {request: {courseid, userid, chosendate, chosentime, note, confirmed = false}}
////    Response: вернуть ошибку, если пользователь уже записан на это время
////    Если все успешно, данные дата и время попадают в неподтвержденные записи
////    у администратора, и как неподтвержденные – в личный кабинет пользователя,
////    тренеру отправляется оповещение на e-mail о новой записи. Выбранное время перестает
////    быть свободным. В базу данных заносится параметр confirmed = false, который поменяется на true
////    после подтверждения. У интервала по intervalid значение busy меняется на true. Заявке присваивается id – requestid.
//
//
//}
//
//
//
//
//
/////courseid/datestimes - получаем незанятые даты и время у конкретного тренера с
////    конкретной длительностью сеанса курса по нажатию "Записаться на курс" по courseid из intervals.
////    Параметр "duration" должен быть получен из courseid (то есть каждый course должен знать свой duration) +
////    добавляться 30 минут на перерыв. То есть, если "duration" - 1 час 30 минут, то, чтобы была
////    возможность записаться на курс, промежуток найденного времени (intervalid) должен составлять 2 часа.
////    Диапазон дат для записей - месяц. Если пользователь не залогинен, - переадресация на логин/регистрацию
////    и после нее получение возможных дат и времени. Когда пользователь залогинен, будет ли добавляться ко
////    всем ссылкам-действиям вначале /userid , где оно важно? Важно привязать конкретные курсы к конкретным тренерам.
////    Чтобы курсы с id (к примеру) 1,2,3 попадали в расписание тренера trainerid. Ведущими одного курса могут быть два тренера,
////    тогда при записи на курс к одному тренеру будет courseid отличное, от courseid при записи на этот же курс к другому тренеру.
////            Response:
////    Если свободные дата и время найдены, то возвращает suggesteddate и suggestedtime. Дальше выбор времени, даты, курса,
////    добавление сообщения по желанию, переход к шагу /courseid/choose.
////    Если свободные дата и время не найдены, добавить userid и courseid в список ожидания (/waitinglist)
////    администратора и выдать сообщение о том, что, к сожалению, на данный курс пока нет свободного времени,
////    но ваше имя добавлено в список ожидающих, и вы будете оповещены, когда появится время для записи.
//
//
//
}