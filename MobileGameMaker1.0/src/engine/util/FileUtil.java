/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {

    public static boolean CreateFile(String destFileName) {
        File file = new File(destFileName);
        if (file.exists()) {
            System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�Ŀ���ļ��Ѵ��ڣ�");
            return false;
        }
        if (destFileName.endsWith(File.separator)) {
            System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�Ŀ�겻����Ŀ¼��");
            return false;
        }
        if (!file.getParentFile().exists()) {
            System.out.println("Ŀ���ļ�����·�������ڣ�׼������������");
            if (!file.getParentFile().mkdirs()) {
                System.out.println("����Ŀ¼�ļ����ڵ�Ŀ¼ʧ�ܣ�");
                return false;
            }
        }
        // ����Ŀ���ļ�
        try {
            if (file.createNewFile()) {
                System.out.println("���������ļ�" + destFileName + "�ɹ���");
                return true;
            } else {
                System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�");
            return false;
        }
    }
// ɾ���ļ���
// param folderPath �ļ�����������·��

    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); // ɾ����������������
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); // ɾ�����ļ���
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

// ɾ��ָ���ļ����������ļ�
// param path �ļ�����������·��
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);// ��ɾ���ļ���������ļ�
//                delFolder(path + "/" + tempList[i]);// ��ɾ�����ļ���
                flag = true;
            }
        }
        return flag;
    }

    /**
     * ɾ�������ļ�
     * @param   sPath    ��ɾ���ļ����ļ���
     * @return 
     */
    public static void deleteFile(String sPath) {
        File file = new File(sPath);
        // ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��
        if (file.isFile() && file.exists()) {
            file.delete();
//            file.deleteOnExit();
        }
    }

    /**
     * ����һ��Ŀ¼�����ļ���ָ��·����
     *
     * @param source
     * @param target
     */
    public static void copy(File source, File target) {
        File tarpath = new File(target, source.getName());
        if (source.isDirectory()) {
            tarpath.mkdir();
            File[] dir = source.listFiles();
            for (int i = 0; i < dir.length; i++) {
                copy(dir[i], tarpath);
            }
        } else {
            try {
                InputStream is = new FileInputStream(source);
                OutputStream os = new FileOutputStream(tarpath);
                byte[] buf = new byte[1024];
                int len = 0;
                while ((len = is.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
                is.close();
                os.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void copyFile(File sourceFile, File targetFile)
        throws IOException {
// �½��ļ����������������л���
        FileInputStream input = new FileInputStream(sourceFile);
        BufferedInputStream inBuff = new BufferedInputStream(input);
// �½��ļ���������������л���
        FileOutputStream output = new FileOutputStream(targetFile);
        BufferedOutputStream outBuff = new BufferedOutputStream(output);

// �������� 
        byte[] b = new byte[1024 * 5];
        int len;
        while ((len = inBuff.read(b)) != -1) {
            outBuff.write(b, 0, len);
        }
// ˢ�´˻���������
        outBuff.flush();

//�ر���
        inBuff.close();
        outBuff.close();
        output.close();
        input.close();
    }

    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("����Ŀ¼" + destDirName + "ʧ�ܣ�Ŀ��Ŀ¼�Ѵ��ڣ�");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        // ��������Ŀ¼
        if (dir.mkdirs()) {
            System.out.println("����Ŀ¼" + destDirName + "�ɹ���");
            return true;
        } else {
            System.out.println("����Ŀ¼" + destDirName + "�ɹ���");
            return false;
        }
    }

    public static String createTempFile(String prefix, String suffix, String dirName) {
        File tempFile = null;
        try {
            if (dirName == null) {
                // ��Ĭ���ļ����´�����ʱ�ļ�
                tempFile = File.createTempFile(prefix, suffix);
                return tempFile.getCanonicalPath();
            } else {
                File dir = new File(dirName);
                // �����ʱ�ļ�����Ŀ¼�����ڣ����ȴ���
                if (!dir.exists()) {
                    if (!FileUtil.createDir(dirName)) {
                        System.out.println("������ʱ�ļ�ʧ�ܣ����ܴ�����ʱ�ļ�����Ŀ¼��");
                        return null;
                    }
                }
                tempFile = File.createTempFile(prefix, suffix, dir);
                return tempFile.getCanonicalPath();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("������ʱ�ļ�ʧ��" + e.getMessage());
            return null;
        }
    }
}
