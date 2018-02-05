package bl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import bl.json.ForumJSON;
import bl.json.ForumsJSON;
import bl.json.TestJSON;
import bl.json.TestsJSON;
import bl.json.UserJSON;
import bl.json.UsersJSON;
import dl.*;
import eus.ehu.INTEL901_504021.TTA1718.utils.FileUtils;

@Singleton
@Path("/gurasApp")
public class LogicREST {

	@Context
	private javax.servlet.http.HttpServletRequest hsr;

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllUsers")
	public UsersJSON getAllUsers() {
		System.out.println("getAllUsers: " + hsr.getRemoteAddr());
		UsersJSON usersJSON = new UsersJSON();

		List<User> rolledTestList = (List<User>) em.createNamedQuery("User.findAll").getResultList();
		if (rolledTestList.size() != 0) {
			List<UserJSON> userList = new ArrayList<UserJSON>();
			for (int i = 0; i < rolledTestList.size(); i++) {
				User user = rolledTestList.get(i);

				UserJSON userJSON = new UserJSON(user.getLogin(), user.getName(), user.getEmail(), user.getPassword());
				userList.add(userJSON);
			}

			usersJSON.setUsers(userList);
			usersJSON.setTotal(rolledTestList.size());
		}

		return usersJSON;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getTests")
	public TestsJSON getTests(@QueryParam("login") String login) {
		System.out.println("getTests: " + hsr.getRemoteAddr() + " login: " + login);
		TestsJSON testsJSON = new TestsJSON();

		List<User> rolledUserList = (List<User>) em.createNamedQuery("User.findLogin").setParameter("login", login)
				.getResultList();
		if (rolledUserList.size() != 0) {
			List<Test> rolledTestList = (List<Test>) em.createNamedQuery("Test.findAll").getResultList();
			if (rolledTestList.size() != 0) {
				List<TestJSON> testList = new ArrayList<TestJSON>();
				for (int i = 0; i < rolledTestList.size(); i++) {
					Test test = rolledTestList.get(i);

					List<String> answerES = new ArrayList<String>();
					List<String> answerEU = new ArrayList<String>();

					answerES.add(test.getAnswer1ES());
					answerES.add(test.getAnswer2ES());
					answerES.add(test.getAnswer3ES());
					answerES.add(test.getAnswer4ES());

					answerEU.add(test.getAnswer1EU());
					answerEU.add(test.getAnswer2EU());
					answerEU.add(test.getAnswer3EU());
					answerEU.add(test.getAnswer4EU());

					TestJSON testJSON = new TestJSON(test.getQuestionES(), test.getQuestionEU(), answerES, answerEU,
							test.getCorrectAnswer(), test.getAdviceES(), test.getAdviceEU());
					testList.add(testJSON);
				}

				testsJSON.setTests(testList);
				testsJSON.setTotal(rolledTestList.size());
			}
		}

		return testsJSON;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllForums")
	public ForumsJSON getAllForums() {
		System.out.println("getForums: " + hsr.getRemoteAddr());
		ForumsJSON forumsJSON = new ForumsJSON();

		List<Forum> rolledForumList = null;

		rolledForumList = (List<Forum>) em.createNamedQuery("Forum.findAll").getResultList();

		if (rolledForumList.size() != 0) {
			List<ForumJSON> forumList = new ArrayList<ForumJSON>();
			for (int i = 0; i < rolledForumList.size(); i++) {
				Forum forum = rolledForumList.get(i);
				ForumJSON forumJSON = new ForumJSON(forum.getUser().getLogin(), forum.getTitle(), forum.getQuestion(),
						forum.getAnswer(), forum.getTeacher(), forum.getDate());
				forumList.add(forumJSON);
			}

			forumsJSON.setForums(forumList);
			forumsJSON.setTotal(rolledForumList.size());
		}

		return forumsJSON;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getForums")
	public ForumsJSON getForums(@QueryParam("login") String login, @QueryParam("date") int date) {
		System.out.println("getForums: " + hsr.getRemoteAddr() + " login: " + login + " date: " + date);
		ForumsJSON forumsJSON = new ForumsJSON();

		List<User> rolledUserList = (List<User>) em.createNamedQuery("User.findLogin").setParameter("login", login)
				.getResultList();
		if (rolledUserList.size() != 0) {
			User user = rolledUserList.get(0);
			List<Forum> rolledForumList = null;
			if (date != 0) {
				rolledForumList = (List<Forum>) em.createNamedQuery("Forum.findFromDateAndUser")
						.setParameter("user", user.getId()).setParameter("date", date).getResultList();
			} else {
				System.out.println("getForums: Date equals 0");
				rolledForumList = (List<Forum>) em.createNamedQuery("Forum.findUser").setParameter("user", user.getId())
						.getResultList();
			}

			if (rolledForumList.size() != 0) {
				List<ForumJSON> forumList = new ArrayList<ForumJSON>();
				for (int i = 0; i < rolledForumList.size(); i++) {
					Forum forum = rolledForumList.get(i);
					ForumJSON forumJSON = new ForumJSON(null, forum.getTitle(), forum.getQuestion(), forum.getAnswer(),
							forum.getTeacher(), forum.getDate());
					forumList.add(forumJSON);
				}

				forumsJSON.setForums(forumList);
				forumsJSON.setTotal(rolledForumList.size());
			}
		}

		return forumsJSON;
	}

	@PostConstruct
	private void buildFolderTree() {
		String contextName = hsr.getContextPath().substring(1);
		String folderNames[] = { "audio" };

		FileUtils.generateFolderTree(contextName, folderNames);
	}

	@Path("/uploadFile")
	@POST
	@Consumes("multipart/form-data")
	public Response uploadFile(MultipartFormDataInput input) {
		System.out.println("uploadFile: " + hsr.getRemoteAddr());

		return FileUtils.uploadFile(input);
	}

	@SuppressWarnings("unchecked")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/register")
	public Response register(UserJSON userJSON) {
		System.out.println("register: " + hsr.getRemoteAddr());
		String responseText = null;

		List<User> rolledUserList = (List<User>) em.createNamedQuery("User.findEmail")
				.setParameter("email", userJSON.getEmail()).getResultList();
		if (rolledUserList.size() == 0) {

			String loginPrefix = userJSON.getName().substring(0, 1).toLowerCase()
					+ userJSON.getEmail().substring(0, 1).toLowerCase();

			List<User> users = (List<User>) em.createNamedQuery("User.findAllLoginPrefix")
					.setParameter("loginPrefix", "%" + loginPrefix + "%").getResultList();

			User user = new User();
			user.setName(userJSON.getName());
			user.setEmail(userJSON.getEmail());
			user.setPassword(userJSON.getPassword());
			user.setLogin(loginPrefix + users.size());

			em.persist(user);
			responseText = user.getLogin();
		} else
			responseText = "ERROR";

		return Response.status(200).entity(responseText).build();
	}

	@SuppressWarnings("unchecked")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/login")
	public Response login(UserJSON userJSON) {
		System.out.println("login: " + hsr.getRemoteAddr());
		String responseText = null;

		List<User> rolledUserList = (List<User>) em.createNamedQuery("User.findLogin")
				.setParameter("login", userJSON.getLogin()).getResultList();
		if (rolledUserList.size() == 0) {
			responseText = "LOGIN ERROR";
		} else {
			if (rolledUserList.get(0).getPassword().equals(userJSON.getPassword()))
				responseText = "LOGIN OK";
			else
				responseText = "LOGIN ERROR";

		}

		return Response.status(200).entity(responseText).build();
	}

	@SuppressWarnings("unchecked")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/addQuestion")
	public Response addQuestion(ForumJSON forumJSON) {
		System.out.println("addQuestion: " + hsr.getRemoteAddr());
		String responseText = null;

		List<User> rolledUserList = (List<User>) em.createNamedQuery("User.findLogin")
				.setParameter("login", forumJSON.getLogin()).getResultList();
		if (rolledUserList.size() == 0) {
			responseText = "QUESTION ADD ERROR";
		} else {
			User user = rolledUserList.get(0);
			Forum forum = new Forum();
			forum.setUser(user);
			forum.setQuestion(forumJSON.getQuestion());
			forum.setTitle(forumJSON.getTitle());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int date = day + month * 100 + year * 10000;
			forum.setDate(date);
			em.persist(forum);
			responseText = "QUESTION ADDED";
		}

		return Response.status(200).entity(responseText).build();
	}

	@SuppressWarnings("unchecked")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/answerQuestion")
	public Response answerQuestion(ForumJSON forumJSON) {
		System.out.println("answerQuestion: " + hsr.getRemoteAddr());
		String responseText = "ERROR";

		if (forumJSON != null && forumJSON.getAnswer() != null && forumJSON.getLogin() != null
				&& forumJSON.getQuestion() != null && forumJSON.getTeacher() != null && forumJSON.getTitle() != null) {

			List<Forum> rolledForumList = (List<Forum>) em.createNamedQuery("Forum.findFromQuestAndLogin")
					.setParameter("login", forumJSON.getLogin()).setParameter("question", forumJSON.getQuestion())
					.getResultList();

			if (rolledForumList.size() == 1) {

				Forum forum = rolledForumList.get(0);;
				forum.setAnswer(forumJSON.getAnswer());
				forum.setTeacher(forumJSON.getTeacher());
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH) + 1;
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				int date = day + month * 100 + year * 10000;
				forum.setDate(date);
				em.persist(forum);
				responseText = "OK";
			}
		}

		return Response.status(200).entity(responseText).build();
	}
}
