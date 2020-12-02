public class ColourIT
{
  public static void main(String[] args)
  {
    String file = "C:\\Users\\lfpon\\OneDrive - ViaUC\\sdj\\lesson25\\Car\\projects.bin";
    ProjectFileAdapter pfa = new ProjectFileAdapter(
        file);

    ProjectList list = new ProjectList();
    list.addProject(new Project("123", "blablabla", "blablabla"));
    list.addProject(new Project("124", "blablabla", "blablabla"));
    list.addProject(new Project("143", "blablabla", "blablabla"));

    Requirement requirement = new Requirement();
    Requirement requirement1 = new Requirement();
    Requirement requirement2 = new Requirement();
    Requirement requirement3 = new Requirement();
    Requirement requirement4 = new Requirement();

    RequirementList requirements = new RequirementList();
    requirements.addRequirement(requirement);
    requirements.addRequirement(requirement1);
    requirements.addRequirement(requirement2);
    requirements.addRequirement(requirement3);
    requirements.addRequirement(requirement4);

    list.getProject(1).setRequirements(requirements);

    pfa.saveProjects(list);

    System.out.println("All Projects:");
    System.out.println(
        "------------------------------------------------------------");
    System.out.println(list);
  }
}