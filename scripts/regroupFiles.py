
import os
import shutil

# Set the top-level directory path
top_dir = '/mnt/partages/videos/films/'

# Loop through all directories and files in the directory tree
for root, dirs, files in os.walk(top_dir):
    for file in files:
        # Check if the file is an NFO file
        if file.endswith('.nfo'):
            # Get the NFO file name (without the extension)
            nfo_name = os.path.splitext(file)[0]
            
            # Create the subdirectory if it doesn't already exist
            sub_dir = os.path.join(root, nfo_name)
            parent_name=os.path.dirname(sub_dir).split("/")[-1]
            #print (f"dir parent {parent_name}")
            if parent_name == nfo_name:
                        print(f"XXXX directory {nfo_name} is recursiv {sub_dir}")
                        continue  # Skip moving the file
            if not os.path.exists(sub_dir):
                #print("make dire "+sub_dir)
                os.mkdir(sub_dir)
            
            # Loop through all files in the directory and move files
            # with a name starting by the NFO file name to the subdirectory
            for file2 in files:
               
                file2_name, file_ext = os.path.splitext(file2)
                if file2_name==nfo_name or  file2.startswith(nfo_name+"-poster") or file2.startswith(nfo_name+"-logo") or file2.startswith(nfo_name+"-backdrop") :
                    src_path = os.path.join(root, file2)
                    dst_path = os.path.join(sub_dir, file2)
                    shutil.move(src_path, dst_path)
                    #print(f"move file {src_path} to {dst_path}")