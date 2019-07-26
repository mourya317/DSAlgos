package SystemDesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 17-07-2019
 */
public class InMemoryFileSystem {

    static class Dir{
        HashMap<String, Dir> dirs = new HashMap<>();
        HashMap<String, String> files = new HashMap<>();
    }

    static Dir root;
    public InMemoryFileSystem(){
        root = new Dir();
    }


    /*
    List the contents of a path in lexicographical order
     */
    public List<String> ls(String path){
        Dir currentDir = root;
        List<String> files = new ArrayList<>();
        if(!path.equals("/")){
            //process the path
            String[] d = path.split("/");
            //Drilldown inside the paths
            for(int i=1;i<d.length;i++){
                currentDir = currentDir.dirs.get(d[i]);
            }
            //Match for a file in the currentdir, if not get the files of the matched dir
            if(currentDir.files.containsKey(d[d.length-1])){
                files.add(d[d.length-1]);
                return files;
            }else{
                //it is a dir, we need to list the dir

            }
        }
        files.addAll(new ArrayList<>(currentDir.dirs.keySet()));
        files.addAll(new ArrayList<>(currentDir.files.keySet()));
        Collections.sort(files);
        return files;
    }

    /*
    mkdir
     */

    public Dir mkdir(String path){
        Dir currentDir = root;
        String[] d = path.split("/");
        for(int i=1;i<d.length;i++){
            if(!currentDir.dirs.containsKey(d[i])){
                currentDir.dirs.put(d[i],new Dir());
            }
            currentDir = currentDir.dirs.get(d[i]);
        }
        return currentDir;
    }

    public void addContentToFile(String filePath, String content) {
        Dir t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            t = t.dirs.get(d[i]);
        }
        t.files.put(d[d.length - 1], t.files.getOrDefault(d[d.length - 1], "") + content);
    }

    public String readContentFromFile(String filePath) {
        Dir t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            t = t.dirs.get(d[i]);
        }
        return t.files.get(d[d.length - 1]);
    }


    public static void main(String[] args) {
        InMemoryFileSystem fileSystem = new InMemoryFileSystem();
        System.out.println("contents start-----");
        fileSystem.ls("/").forEach(s -> System.out.println(s));
        System.out.println("contents end----");
        fileSystem.mkdir("/a/b/c");


        fileSystem.addContentToFile("/a/b/c/m.txt","This is mourya");
        fileSystem.addContentToFile("/a/b/c/n.txt","This is mourya");
        fileSystem.addContentToFile("/a/b/c/o.txt","This is mourya");
        fileSystem.addContentToFile("/a/b/c/p.txt","This is mourya");
        fileSystem.addContentToFile("/a/b/c/q.txt","This is mourya");
        fileSystem.addContentToFile("/a/b/c/r.txt","This is mourya");
        fileSystem.mkdir("/a/b/c/d");
        fileSystem.mkdir("/a/b/c/d/e");
        System.out.println("reading contents of file::"+fileSystem.readContentFromFile("/a/b/c/m.txt"));

        System.out.println("contents start-----");
        fileSystem.ls("/a/b/c").forEach(s -> System.out.println(s));
        System.out.println("contents end----");

    }





}
